package git;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

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
}
