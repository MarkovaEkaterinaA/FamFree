

import com.project.familytree.service.FamilyTreeService;
import com.project.familytree.view.FamilyTreeView;

public class FamilyTreePresenter {
    private final FamilyTreeView view;
    private final FamilyTreeService service;

    public FamilyTreePresenter(FamilyTreeView view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
    }

    public void displayFamilyTree() {
        view.displayTree(service.getFamilyTree().toString());
    }

   
}
