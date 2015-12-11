package kimxu.panadapter.itemfactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kimxu.kadapter.AssemblyGroupItem;
import kimxu.kadapter.AssemblyGroupItemFactory;
import kimxu.panadapter.bean.GameGroup;
import me.xiaopan.assemblyadaptersample.R;


public class GameGroupItemFactory extends AssemblyGroupItemFactory<GameGroupItemFactory.GameGroupItem> {

    @Override
    public Class<?> getBeanClass() {
        return GameGroup.class;
    }

    @Override
    public GameGroupItem createAssemblyItem(ViewGroup parent) {
        return new GameGroupItem(parent, this);
    }

    public static class GameGroupItem extends AssemblyGroupItem<GameGroup, GameGroupItemFactory> {
        private TextView titleTextView;

        protected GameGroupItem(ViewGroup parent, GameGroupItemFactory itemFactory) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group_game, parent, false), itemFactory);
        }

        @Override
        protected void onFindViews(View convertView) {
            titleTextView = (TextView) convertView.findViewById(R.id.text_gameListGroup_name);
        }

        @Override
        protected void onConfigViews(Context context) {

        }

        @Override
        protected void onSetData(int groupPosition, boolean isExpanded, GameGroup gameGroup) {
            if(isExpanded){
                titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_collapse, 0);
            }else{
                titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_expand, 0);
            }
            titleTextView.setText(gameGroup.title);
        }
    }
}
