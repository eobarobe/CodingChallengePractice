import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<List<Integer>> LOTraversal(TreeNode root){
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        Queue<TreeNode> discoveredQ = new LinkedList<>();
        discoveredQ.add(root);
        while (!discoveredQ.isEmpty()){
            int qSize = discoveredQ.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i<qSize ; i++){
                TreeNode curr = discoveredQ.remove();
                currentLevel.add(curr.val);
                if (curr.left != null){
                    discoveredQ.add(curr.left);
                }
                if (curr.right != null){
                    discoveredQ.add(curr.right);
                }
                results.add(currentLevel);

            }
        }
        System.out.println(results);
        return results;
    }
}
