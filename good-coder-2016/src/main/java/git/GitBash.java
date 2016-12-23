package git;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

/**
 * Created by long.yl Created in 2016/11/1 Created on Basara_git
 */
public class GitBash {

	private static GitBash instance;

	private static Repository repository;

    private static final List<String> WHITELIST_BRANCH;

    static {
        WHITELIST_BRANCH = new ArrayList<>();
        WHITELIST_BRANCH.add("master");
    }

	private GitBash() {
	}

	public static GitBash getInstance(String path) {
		if (instance == null) {
			synchronized (GitBash.class) {
				if (instance == null) {
					instance = new GitBash();
					try {
						repository = new FileRepositoryBuilder().setGitDir(new File(path)).build();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return instance;
	}

	public String getConfig(String config, String name) {
		Config cfg = repository.getConfig();
		return cfg.getString(config, null, name);
	}

	public String getHeadSHA1Code(String branchName) {
		try {
			Ref branch = repository.getRef(branchName);
			return branch.getObjectId().getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

    // 创建分支
	public boolean createBranch(String baseBranchName, String newBranchName) {
        try {
            Ref baseBranch = repository.getRef(baseBranchName);
            if (baseBranch == null){
                throw new IllegalArgumentException("源分支不存在");
            }
            ObjectId baseBranchObjectId = baseBranch.getObjectId();
            RefUpdate createBranch = repository.updateRef("refs/heads/" + newBranchName);
            createBranch.setNewObjectId(baseBranchObjectId);
            RefUpdate.Result result = createBranch.update();
            // 新增:NEW,已经存在:NO_CHANGE
            return result == RefUpdate.Result.NEW;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
	}


    // 删除分支
	public boolean deleteBranch(String branchName) {
        if (ArrayUtils.contains(WHITELIST_BRANCH.toArray(), branchName)){
            throw new IllegalArgumentException("该分支无法删除");
        }
        try {
            RefUpdate deleteBranch = repository.updateRef("refs/heads/" + branchName);
            deleteBranch.setForceUpdate(true);
            RefUpdate.Result result = deleteBranch.delete();
            // 删除:FORCED
            return result == RefUpdate.Result.FORCED;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
	}

    public void diff(String branchName){
        try {
            ObjectId oldHead = repository.resolve("HEAD^^^^{tree}");
            ObjectId head = repository.resolve("HEAD^{tree}");
            System.out.println("Printing diff between tree: " + oldHead + " and " + head);
            ObjectReader reader = repository.newObjectReader();
            CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
            oldTreeIter.reset(reader, oldHead);
            CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
            newTreeIter.reset(reader, head);

            // finally get the list of changed files
            Git git = new Git(repository);
            List<DiffEntry> diffs= git.diff()
                    .setNewTree(newTreeIter)
                    .setOldTree(oldTreeIter)
                    .call();
            for (DiffEntry entry : diffs) {
                System.out.println("Entry: " + entry);
            }
        }catch (Exception e){

        }
        System.out.println("Done");
    }

    public void load(){
        try {

            Ref head = repository.exactRef("refs/heads/master");
            System.out.println("Ref of refs/heads/master: " + head);

            System.out.println("\nPrint contents of head of master branch, i.e. the latest commit information");
            ObjectLoader loader = repository.open(head.getObjectId());
            loader.copyTo(System.out);

            System.out.println("\nPrint contents of tree of head of master branch, i.e. the latest binary tree information");

            // a commit points to a tree
            RevWalk walk = new RevWalk(repository);
            RevCommit commit = walk.parseCommit(head.getObjectId());
            RevTree tree = walk.parseTree(commit.getTree().getId());
            System.out.println("Found Tree: " + tree);
            loader = repository.open(tree.getId());
            loader.copyTo(System.out);

            walk.dispose();
        }catch (Exception e){

        }
    }
}
