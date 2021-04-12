package markup;

import java.util.List;

public class UnorderedList extends AbstractElement implements AllowedInListItem {
    public UnorderedList(List<ListItem> items) {
        super(items);
    }

    @Override
    protected String getOpenBBCodeTag() {
        return "[list]";
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