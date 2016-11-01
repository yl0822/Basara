package git;

import java.io.File;

import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Created by long.yl Created in 2016/11/1 Created on Basara_git
 */
public class GitBash {

	private static GitBash instance;

	private static Repository repository;

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
	public void createBranch(String baseBranchName, String newBranchName) {
        try {
            Ref baseBranch = repository.getRef(baseBranchName);
            ObjectId baseBranchObjectId = baseBranch.getObjectId();
            RefUpdate createBranch = repository.updateRef(newBranchName);
            createBranch.setNewObjectId(baseBranchObjectId);
            createBranch.update();
        }catch (Exception e){
            e.printStackTrace();
        }
	}

    // 删除分支
	public void deleteBranch(String branchName) {
        try {
            RefUpdate deleteBranch1 = repository.updateRef(branchName);
            deleteBranch1.setForceUpdate(true);
            deleteBranch1.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
	}
}
