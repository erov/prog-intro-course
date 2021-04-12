package markup;

import java.util.List;

public class OrderedList extends AbstractElement implements AllowedInListItem {
    public OrderedList(List<ListItem> items) {
        super(items);
    }

    @Override
    protected String getOpenBBCodeTag() {
        return "[list=1]";
    }

    @Override
    protected String getCloseBBCodeTag() {
        return "[/list]";
    }

    @Override
    protected String getMarkdownTag() {
        return "";
    }
}
