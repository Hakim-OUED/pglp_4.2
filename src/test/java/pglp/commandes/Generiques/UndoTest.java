package pglp.commandes.Generiques;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UndoTest {

    void init(){

    }

    @Test
    public void testMAJHistorique(){
        Undo undo = new Undo();
        Stack<Double> pileO = new Stack<>();
        Deque<String> exp = new ArrayDeque<>();
        exp.add("1");
        exp.add("4");
        pileO.push(1.0);
        pileO.push(4.0);
        undo.majHitorique(pileO, exp);
        assertTrue(undo.getOperandesHistorique().pop().pop() == 4.0);
    }

    @Test
    public void testUndo(){
        Undo undo = new Undo();
        Stack<Double> pileO = new Stack<>();
        Deque<String> exp = new ArrayDeque<>();
        exp.add("1");
        pileO.push(1.0);
        undo.majHitorique((Stack<Double>) pileO.clone(), exp);
        pileO.push(4.0);
        exp.add("4");
        undo.majHitorique((Stack<Double>) pileO.clone(), exp);
        pileO.push(8.0);
        exp.add("8");
        undo.majHitorique((Stack<Double>) pileO.clone(), exp);
        undo.execute();
        System.out.println(undo.getOperandesHistorique());
        assertFalse(undo.getOperandesHistorique().pop().pop() == 8.0);
    }

}
