package kimxu.panadapter.bean;

import java.util.List;

import kimxu.kadapter.AssemblyGroup;

public class UserGroup implements AssemblyGroup {
    public String title;
    public List<User> userList;

    @Override
    public int getChildCount() {
        return userList != null ? userList.size() : 0;
    }

    @Override
    public Object getChild(int childPosition) {
        return userList != null && childPosition < userList.size() ? userList.get(childPosition) : null;
    }
}