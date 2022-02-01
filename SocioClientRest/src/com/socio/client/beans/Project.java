package com.socio.client.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project {

	public enum Visibility {
		PUBLIC, PRIVATE, PROTECTED;

		public static boolean isVisibility(String text) {
			String textUpper = text.toUpperCase();
			if (textUpper.equals(PUBLIC.name()) || textUpper.equals(PRIVATE.name())
					|| textUpper.equals(PROTECTED.name())) {
				return true;
			}
			return false;
		}
	};

	public static class Subproject {
		private String name;
		private long id;

		public static Subproject createSubproject(JSONObject object) {
			if (object.isNull("name") || object.isNull("id")) {
				return null;
			}
			Subproject subproject = new Subproject();
			subproject.setName(object.getString("name"));
			subproject.setId(object.getLong("id"));
			return subproject;
		}

		public Subproject() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Subproject [name=" + name + ", id=" + id + "]";
		}

	}

	private User admin;
	private String name;
	private long id;
	private String type;
	private Visibility visibility;
	private boolean isOpen;
	private boolean isBranch;
	private Date createDate;
	private List<User> canEdit;
	private List<User> canRead;
	private String branchGroup;
	private Subproject father;
	private Map<String, List<Subproject>> openBranchs = new HashMap<>();
	private List<String> closeBranchs = new ArrayList<>();

	public static Project createProject(JSONObject object) {
		if (!object.isNull("Project")) {
			object=object.getJSONObject("Project");
		}
		if (!object.isNull("project")) {
			object=object.getJSONObject("project");
		}

		if (object.isNull("admin") || object.isNull("name") || object.isNull("id") || object.isNull("type")
				|| object.isNull("visibility") || object.isNull("isOpen") || object.isNull("isBranch")
				|| object.isNull("createDate") || object.isNull("usersCanEdit") || object.isNull("usersCanRead")) {
			return null;
		}

		Project project = new Project();
		project.setAdmin(User.createUser(object.getJSONObject("admin")));
		project.setName(object.getString("name"));
		project.setId(object.getLong("id"));
		project.setType(object.getString("type"));
		project.setVisibility(Visibility.valueOf(object.getString("visibility")));
		project.setOpen(object.getBoolean("isOpen"));
		project.setBranch(object.getBoolean("isBranch"));
		project.setCreateDate(new Date(object.getLong("createDate")));

		JSONArray editList = object.getJSONArray("usersCanEdit");

		List<User> userCanEdit = new ArrayList<>();
		for (int i = 0; i < editList.length(); i++) {
			JSONObject edit = editList.getJSONObject(i);
			userCanEdit.add(User.createUser(edit));
		}
		project.setCanEdit(userCanEdit);

		JSONArray readList = object.getJSONArray("usersCanRead");

		List<User> userCanRead = new ArrayList<>();
		for (int i = 0; i < readList.length(); i++) {
			JSONObject read = readList.getJSONObject(i);
			userCanRead.add(User.createUser(read));
		}
		project.setCanRead(userCanRead);

		if (project.isBranch()) {
			if (!object.isNull("father")) {
				project.setFather(Subproject.createSubproject(object.getJSONObject("father")));
			}
			if (!object.isNull("branchGroup")) {
				project.setBranchGroup(object.getString("branchGroup"));
			}
		} else {
			if (!object.isNull("openBranchs")) {
				Map<String, List<Subproject>> openBranchs = new HashMap<>();
				JSONArray openBranchsArray = object.getJSONArray("openBranchs");
				for (int i = 0; i < openBranchsArray.length(); i++) {

					JSONObject branch = openBranchsArray.getJSONObject(i);
					String branchGroup = branch.getString("branchGroup");

					List<Subproject> subprojects = openBranchs.get(branchGroup);
					if (subprojects == null) {
						subprojects = new ArrayList<>();
					}
					subprojects.add(Subproject.createSubproject(branch));
					openBranchs.put(branchGroup, subprojects);

				}
				project.setOpenBranchs(openBranchs);
			}
			if (!object.isNull("closeBranchs")) {
				List<String> closeBranchs = new ArrayList<>();
				JSONArray closeBranchsArray = object.getJSONArray("closeBranchs");
				for (int i = 0; i < closeBranchsArray.length(); i++) {
					closeBranchs.add(closeBranchsArray.getString(i));
				}
				project.setCloseBranchs(closeBranchs);
			}
		}

		return project;
	}

	public Project() {
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getCompleteName() {
		return admin.getReference() + "/" + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public String getOpenStatus() {
		if (isOpen) {
			return "Open";
		} else {
			return "Close";
		}
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isBranch() {
		return isBranch;
	}

	public void setBranch(boolean isBranch) {
		this.isBranch = isBranch;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<User> getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(List<User> canEdit) {
		this.canEdit = canEdit;
	}

	public List<User> getCanRead() {
		return canRead;
	}

	public void setCanRead(List<User> canRead) {
		this.canRead = canRead;
	}

	public String getBranchGroup() {
		return branchGroup;
	}

	public void setBranchGroup(String branchGroup) {
		this.branchGroup = branchGroup;
	}

	public Subproject getFather() {
		return father;
	}

	public void setFather(Subproject father) {
		this.father = father;
	}

	public Map<String, List<Subproject>> getOpenBranchs() {
		return openBranchs;
	}

	public void setOpenBranchs(Map<String, List<Subproject>> openBranchs) {
		this.openBranchs = openBranchs;
	}

	public List<String> getCloseBranchs() {
		return closeBranchs;
	}

	public void setCloseBranchs(List<String> closeBranchs) {
		this.closeBranchs = closeBranchs;
	}

	@Override
	public String toString() {
		return "Project [admin=" + admin + ", name=" + name + ", id=" + id + ", type=" + type + ", visibility="
				+ visibility + ", isOpen=" + isOpen + ", isBranch=" + isBranch + ", createDate=" + createDate
				+ ", canEdit=" + canEdit + ", canRead=" + canRead + ", branchGroup=" + branchGroup + ", father="
				+ father + ", openBranchs=" + openBranchs + ", closeBranchs=" + closeBranchs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
