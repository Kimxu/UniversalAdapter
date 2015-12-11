package kimxu.panadapter.itemfactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kimxu.kadapter.AssemblyGroupItem;
import kimxu.kadapter.AssemblyGroupItemFactory;
import kimxu.panadapter.bean.UserGroup;
import me.xiaopan.assemblyadaptersample.R;

public class UserGroupItemFactory extends AssemblyGroupItemFactory<UserGroupItemFactory.UserGroupItem> {

    @Override
    public Class<?> getBeanClass() {
        return UserGroup.class;
    }

    @Override
    public UserGroupItem createAssemblyItem(ViewGroup parent) {
        return new UserGroupItem(parent, this);
    }

    public static class UserGroupItem extends AssemblyGroupItem<UserGroup, UserGroupItemFactory> {
        private TextView titleTextView;

        protected UserGroupItem(ViewGroup parent, UserGroupItemFactory itemFactory) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group_user, parent, false), itemFactory);
        }

        @Override
        protected void onFindViews(View convertView) {
            titleTextView = (TextView) convertView.findViewById(R.id.text_userListGroup_name);
        }

        @Override
        protected void onConfigViews(Context context) {

        }

        @Override
        protected void onSetData(int groupPosition, boolean isExpanded, UserGroup userGroup) {
            if(isExpanded){
                titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_collapse, 0, 0, 0);
            }else{
                titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_expand, 0, 0, 0);
            }
            titleTextView.setText(userGroup.title);
        }
    }
}
