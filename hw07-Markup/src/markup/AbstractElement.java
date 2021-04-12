package markup;

import java.util.List;

public abstract class AbstractElement implements AllowedInBBCodeAndMarkdown {
    private final List<? extends AllowedInBBCodeAndMarkdown> items;

    protected abstract String getOpenBBCodeTag();
    protected abstract String getCloseBBCodeTag();
    protected abstract String getMarkdownTag();

    protected AbstractElement(List<? extends AllowedInBBCodeAndMarkdown> items) {
        this.items = items;
    }

    @Override
    public void toBBCode(StringBuilder builder) {
        builder.append(getOpenBBCodeTag());
        for (AllowedInBBCode item : items) {
            item.toBBCode(builder);
        }
        builder.append(getCloseBBCodeTag());
    }

    @Override
    public void toMarkdown(StringBuilder builder) {
        builder.append(getMarkdownTag());
        for (AllowedInMarkdown item : items) {
            item.toMarkdown(builder);
        }
        builder.append(getMarkdownTag());
    }
}
