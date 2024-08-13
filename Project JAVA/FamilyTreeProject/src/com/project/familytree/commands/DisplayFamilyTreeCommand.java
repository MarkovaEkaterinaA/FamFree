public class DisplayFamilyTreeCommand implements Command {
    private final FamilyTreePresenter presenter;

    public DisplayFamilyTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.displayFamilyTree();
    }
}
