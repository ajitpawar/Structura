package com.davisosa.structura.dataStores;

import com.davisosa.structura.model.Answer;
import com.davisosa.structura.model.Question;

import java.util.ArrayList;

/**
 * Created by ishan on 15-03-23.
 */
public class QuestionStore {
    private static ArrayList<Question> defaultLLStore;
    private static ArrayList<Question> defaultBSTStore;

    public static ArrayList<Question> getDefaultLLStore() {
        if (QuestionStore.defaultLLStore == null) {
            setDefaultLLStore();
        }
        return defaultLLStore;
    }

    private static void setDefaultLLStore() {

        // q1
        String one_question = "A linear collection of data element given by means of a pointer is called ________";
        String one_answer_string_1  = "Queue";
        String one_answer_string_2  = "Stack";
        String one_answer_string_3  = "Graph";
        String one_answer_string_4  = "Linked List";

        Answer one_answer_1 = new Answer(one_answer_string_1);
        Answer one_answer_2 = new Answer(one_answer_string_2);
        Answer one_answer_3 = new Answer(one_answer_string_3);
        Answer one_answer_4 = new Answer(one_answer_string_4);

        ArrayList<Answer> one_answers = new ArrayList<Answer>();
        one_answers.add(one_answer_1);
        one_answers.add(one_answer_2);
        one_answers.add(one_answer_3);
        one_answers.add(one_answer_4);

        Answer one_correct_answer = one_answer_4;

        Question q1 = new Question(one_question, one_answers, one_correct_answer);

        // q2
        String two_question = "Each node contains minimum of two fields: one field called data field to store data and another field is of type:";
        String two_answer_string_1  = "pointer to node";
        String two_answer_string_2  = "pointer to class";
        String two_answer_string_3  = "pointer to an integer";
        String two_answer_string_4  = "pointer to character";

        Answer two_answer_1 = new Answer(two_answer_string_1);
        Answer two_answer_2 = new Answer(two_answer_string_2);
        Answer two_answer_3 = new Answer(two_answer_string_3);
        Answer two_answer_4 = new Answer(two_answer_string_4);

        ArrayList<Answer> two_answers = new ArrayList<Answer>();
        two_answers.add(two_answer_1);
        two_answers.add(two_answer_2);
        two_answers.add(two_answer_3);
        two_answers.add(two_answer_4);

        Answer two_correct_answer = two_answer_1;

        Question q2 = new Question(two_question, two_answers, two_correct_answer);

        // q3
        String three_question = "Linked list is generally considered as an example of _______ type of  memory allocation";
        String three_answer_string_1  = "Dynamic";
        String three_answer_string_2  = "Static";
        String three_answer_string_3  = "Compile time";
        String three_answer_string_4  = "none of the above";

        Answer three_answer_1 = new Answer(three_answer_string_1);
        Answer three_answer_2 = new Answer(three_answer_string_2);
        Answer three_answer_3 = new Answer(three_answer_string_3);
        Answer three_answer_4 = new Answer(three_answer_string_4);

        ArrayList<Answer> three_answers = new ArrayList<Answer>();
        three_answers.add(three_answer_1);
        three_answers.add(three_answer_2);
        three_answers.add(three_answer_3);
        three_answers.add(three_answer_4);

        Answer three_correct_answer = three_answer_1;

        Question q3 = new Question(three_question, three_answers, three_correct_answer);

        // q4
        String four_question = "Which of the following is not a type of linked list";
        String four_answer_string_1  = "Hybrid Linked List";
        String four_answer_string_2  = "Singly Linked List";
        String four_answer_string_3  = "Circular Linked List";
        String four_answer_string_4  = "Doubly Linked List";

        Answer four_answer_1 = new Answer(four_answer_string_1);
        Answer four_answer_2 = new Answer(four_answer_string_2);
        Answer four_answer_3 = new Answer(four_answer_string_3);
        Answer four_answer_4 = new Answer(four_answer_string_4);

        ArrayList<Answer> four_answers = new ArrayList<Answer>();
        four_answers.add(four_answer_1);
        four_answers.add(four_answer_2);
        four_answers.add(four_answer_3);
        four_answers.add(four_answer_4);

        Answer four_correct_answer = four_answer_1;

        Question q4 = new Question(four_question, four_answers, four_correct_answer);

        // q5
        String five_question = "In Linked List implementation, a node carries information regarding ____";
        String five_answer_string_1  = "data";
        String five_answer_string_2  = "link";
        String five_answer_string_3  = "data and link";
        String five_answer_string_4  = "none of the above";

        Answer five_answer_1 = new Answer(five_answer_string_1);
        Answer five_answer_2 = new Answer(five_answer_string_2);
        Answer five_answer_3 = new Answer(five_answer_string_3);
        Answer five_answer_4 = new Answer(five_answer_string_4);

        ArrayList<Answer> five_answers = new ArrayList<Answer>();
        five_answers.add(five_answer_1);
        five_answers.add(five_answer_2);
        five_answers.add(five_answer_3);
        five_answers.add(five_answer_4);

        Answer five_correct_answer = five_answer_3;

        Question q5 = new Question(five_question, five_answers, five_correct_answer);

        // q6
        String six_question = " A linked list in which the last node of the linked list points to the first is called a ______";
        String six_answer_string_1  = "Circular Linked List";
        String six_answer_string_2  = "Singly Linked List";
        String six_answer_string_3  = "Doubly Linked List";
        String six_answer_string_4  = "none of the above";

        Answer six_answer_1 = new Answer(six_answer_string_1);
        Answer six_answer_2 = new Answer(six_answer_string_2);
        Answer six_answer_3 = new Answer(six_answer_string_3);
        Answer six_answer_4 = new Answer(six_answer_string_4);

        ArrayList<Answer> six_answers = new ArrayList<Answer>();
        six_answers.add(six_answer_1);
        six_answers.add(six_answer_2);
        six_answers.add(six_answer_3);
        six_answers.add(six_answer_4);

        Answer six_correct_answer = six_answer_1;

        Question q6 = new Question(six_question, six_answers, six_correct_answer);

        // q7
        String seven_question = "Linked list data structure usage offers considerable saving in ";
        String seven_answer_string_1  = "Space utilization";
        String seven_answer_string_2  = "Space utilization and computational time";
        String seven_answer_string_3  = "Computational time";
        String seven_answer_string_4  = "none of the above";

        Answer seven_answer_1 = new Answer(seven_answer_string_1);
        Answer seven_answer_2 = new Answer(seven_answer_string_2);
        Answer seven_answer_3 = new Answer(seven_answer_string_3);
        Answer seven_answer_4 = new Answer(seven_answer_string_4);

        ArrayList<Answer> seven_answers = new ArrayList<Answer>();
        seven_answers.add(seven_answer_1);
        seven_answers.add(seven_answer_2);
        seven_answers.add(seven_answer_3);
        seven_answers.add(seven_answer_4);

        Answer seven_correct_answer = seven_answer_2;

        Question q7 = new Question(seven_question, seven_answers, seven_correct_answer);

        // q8
        String eight_question = "Consider linked list is used to implement the Stack then which of the following node is considered as top of the stack? (hint: think LIFO order)";
        String eight_answer_string_1  = "Any node";
        String eight_answer_string_2  = "Middle node";
        String eight_answer_string_3  = "First node";
        String eight_answer_string_4  = "Last node";

        Answer eight_answer_1 = new Answer(eight_answer_string_1);
        Answer eight_answer_2 = new Answer(eight_answer_string_2);
        Answer eight_answer_3 = new Answer(eight_answer_string_3);
        Answer eight_answer_4 = new Answer(eight_answer_string_4);

        ArrayList<Answer> eight_answers = new ArrayList<Answer>();
        eight_answers.add(eight_answer_1);
        eight_answers.add(eight_answer_2);
        eight_answers.add(eight_answer_3);
        eight_answers.add(eight_answer_4);

        Answer eight_correct_answer = eight_answer_3;

        Question q8 = new Question(eight_question, eight_answers, eight_correct_answer);

        // q9
        String nine_question = "In worst case, the number of comparisons needed to search a singly linked list of length n for a given element is";
        String nine_answer_string_1  = "log2 (n)";
        String nine_answer_string_2  = "n/2";
        String nine_answer_string_3  = "log2 (n -1)";
        String nine_answer_string_4  = "n";

        Answer nine_answer_1 = new Answer(nine_answer_string_1);
        Answer nine_answer_2 = new Answer(nine_answer_string_2);
        Answer nine_answer_3 = new Answer(nine_answer_string_3);
        Answer nine_answer_4 = new Answer(nine_answer_string_4);

        ArrayList<Answer> nine_answers = new ArrayList<Answer>();
        nine_answers.add(nine_answer_1);
        nine_answers.add(nine_answer_2);
        nine_answers.add(nine_answer_3);
        nine_answers.add(nine_answer_4);

        Answer nine_correct_answer = nine_answer_4;

        Question q9 = new Question(nine_question, nine_answers, nine_correct_answer);

        // q10
        String ten_question = "Consider a singly linked list implemented as an unordered list. Given the head and tail pointers, which of the following operations could be implemented in O(1):\n\na) Insert item at the front of the list\nb) insert item at the rear of the list\nc) delete item from front of the list\nd) delete item from rear of the list";

        String ten_answer_string_1  = "a and b";
        String ten_answer_string_2  = "a, b, c";
        String ten_answer_string_3  = "a, b, d";
        String ten_answer_string_4  = "a, b, c, d";

        Answer ten_answer_1 = new Answer(ten_answer_string_1);
        Answer ten_answer_2 = new Answer(ten_answer_string_2);
        Answer ten_answer_3 = new Answer(ten_answer_string_3);
        Answer ten_answer_4 = new Answer(ten_answer_string_4);

        ArrayList<Answer> ten_answers = new ArrayList<Answer>();
        ten_answers.add(ten_answer_1);
        ten_answers.add(ten_answer_2);
        ten_answers.add(ten_answer_3);
        ten_answers.add(ten_answer_4);

        Answer ten_correct_answer = ten_answer_2;

        Question q10 = new Question(ten_question, ten_answers, ten_correct_answer);

        ArrayList<Question> qaList = new ArrayList<>();
        qaList.add(q1);
        qaList.add(q2);
        qaList.add(q3);
        qaList.add(q4);
        qaList.add(q5);
        qaList.add(q6);
        qaList.add(q7);
        qaList.add(q8);
        qaList.add(q9);
        qaList.add(q10);

        QuestionStore.defaultLLStore = qaList;

    }

    public static ArrayList<Question> getDefaultBSTStore() {
        if (QuestionStore.defaultBSTStore == null) {
            setDefaultBSTStore();
        }
        return defaultBSTStore;
    }

    private static void setDefaultBSTStore() {

        // q1
        String one_question = "Select the one FALSE statement about binary trees:";
        String one_answer_string_1  = "Every binary tree has at least one node.";
        String one_answer_string_2  = "Every non-empty tree has exactly one root node.";
        String one_answer_string_3  = "Every node has at most two children.";
        String one_answer_string_4  = "Every non-root node has exactly one parent.";

        Answer one_answer_1 = new Answer(one_answer_string_1);
        Answer one_answer_2 = new Answer(one_answer_string_2);
        Answer one_answer_3 = new Answer(one_answer_string_3);
        Answer one_answer_4 = new Answer(one_answer_string_4);

        ArrayList<Answer> one_answers = new ArrayList<Answer>();
        one_answers.add(one_answer_1);
        one_answers.add(one_answer_2);
        one_answers.add(one_answer_3);
        one_answers.add(one_answer_4);

        Answer one_correct_answer = one_answer_1;

        Question q1 = new Question(one_question, one_answers, one_correct_answer);

        // q2
        String two_question = "Select the one true statement.";

        String two_answer_string_1  = "very binary tree is either complete or full.";
        String two_answer_string_2  = "Every complete binary tree is also a full binary tree.";
        String two_answer_string_3  = "Every full binary tree is also a complete binary tree.";
        String two_answer_string_4  = "No binary tree is both complete and full";

        Answer two_answer_1 = new Answer(two_answer_string_1);
        Answer two_answer_2 = new Answer(two_answer_string_2);
        Answer two_answer_3 = new Answer(two_answer_string_3);
        Answer two_answer_4 = new Answer(two_answer_string_4);

        ArrayList<Answer> two_answers = new ArrayList<Answer>();
        two_answers.add(two_answer_1);
        two_answers.add(two_answer_2);
        two_answers.add(two_answer_3);
        two_answers.add(two_answer_4);

        Answer two_correct_answer = two_answer_3;

        Question q2 = new Question(two_question, two_answers, two_correct_answer);


        // q3
        String three_question = "Given a binary search tree, which traversal type would print the values in the nodes in sorted order?";

        String three_answer_string_1  = "Preorder";
        String three_answer_string_2  = "Postorder";
        String three_answer_string_3  = "Inorder";
        String three_answer_string_4  = "None of the above";

        Answer three_answer_1 = new Answer(three_answer_string_1);
        Answer three_answer_2 = new Answer(three_answer_string_2);
        Answer three_answer_3 = new Answer(three_answer_string_3);
        Answer three_answer_4 = new Answer(three_answer_string_4);

        ArrayList<Answer> three_answers = new ArrayList<Answer>();
        three_answers.add(three_answer_1);
        three_answers.add(three_answer_2);
        three_answers.add(three_answer_3);
        three_answers.add(three_answer_4);

        Answer three_correct_answer = three_answer_3;

        Question q3 = new Question(three_question, three_answers, three_correct_answer);

        // q4
        String four_question = "What is a possible scenario to delete a node from a BST:";

        String four_answer_string_1  = "Deleting a node with no children";
        String four_answer_string_2  = "Deleting a node with one child";
        String four_answer_string_3  = "Delete a node with two children";
        String four_answer_string_4  = "All of the above";

        Answer four_answer_1 = new Answer(four_answer_string_1);
        Answer four_answer_2 = new Answer(four_answer_string_2);
        Answer four_answer_3 = new Answer(four_answer_string_3);
        Answer four_answer_4 = new Answer(four_answer_string_4);

        ArrayList<Answer> four_answers = new ArrayList<Answer>();
        four_answers.add(four_answer_1);
        four_answers.add(four_answer_2);
        four_answers.add(four_answer_3);
        four_answers.add(four_answer_4);

        Answer four_correct_answer = four_answer_4;

        Question q4 = new Question(four_question, four_answers, four_correct_answer);

        // q5
        String five_question = "Suppose T is a binary tree with 14 nodes. What is the minimum possible depth of T?";
        String five_answer_string_1  = "0";
        String five_answer_string_2  = "3";
        String five_answer_string_3  = "4";
        String five_answer_string_4  = "5";

        Answer five_answer_1 = new Answer(five_answer_string_1);
        Answer five_answer_2 = new Answer(five_answer_string_2);
        Answer five_answer_3 = new Answer(five_answer_string_3);
        Answer five_answer_4 = new Answer(five_answer_string_4);

        ArrayList<Answer> five_answers = new ArrayList<Answer>();
        five_answers.add(five_answer_1);
        five_answers.add(five_answer_2);
        five_answers.add(five_answer_3);
        five_answers.add(five_answer_4);

        Answer five_correct_answer = five_answer_1;

        Question q5 = new Question(five_question, five_answers, five_correct_answer);

        // q6
        String six_question = " If a node in a BST has two children, then its inorder predecessor has ";
        String six_answer_string_1  = "no left child";
        String six_answer_string_2  = "no right child";
        String six_answer_string_3  = "two children";
        String six_answer_string_4  = "no child";

        Answer six_answer_1 = new Answer(six_answer_string_1);
        Answer six_answer_2 = new Answer(six_answer_string_2);
        Answer six_answer_3 = new Answer(six_answer_string_3);
        Answer six_answer_4 = new Answer(six_answer_string_4);

        ArrayList<Answer> six_answers = new ArrayList<Answer>();
        six_answers.add(six_answer_1);
        six_answers.add(six_answer_2);
        six_answers.add(six_answer_3);
        six_answers.add(six_answer_4);

        Answer six_correct_answer = six_answer_2;

        Question q6 = new Question(six_question, six_answers, six_correct_answer);

        // q7
        String seven_question = "A BST is travered in the following order recursively: Right, root, left. The output sequence will be in ";

        String seven_answer_string_1  = "Ascending order";
        String seven_answer_string_2  = "Bitomic sequence";
        String seven_answer_string_3  = "Descending order";
        String seven_answer_string_4  = "No specific order";

        Answer seven_answer_1 = new Answer(seven_answer_string_1);
        Answer seven_answer_2 = new Answer(seven_answer_string_2);
        Answer seven_answer_3 = new Answer(seven_answer_string_3);
        Answer seven_answer_4 = new Answer(seven_answer_string_4);

        ArrayList<Answer> seven_answers = new ArrayList<Answer>();
        seven_answers.add(seven_answer_1);
        seven_answers.add(seven_answer_2);
        seven_answers.add(seven_answer_3);
        seven_answers.add(seven_answer_4);

        Answer seven_correct_answer = seven_answer_3;

        Question q7 = new Question(seven_question, seven_answers, seven_correct_answer);


        // q8
        String eight_question = "A binary tree whose every node has either zero or two children is called";
        String eight_answer_string_1  = "Complete binary tree";
        String eight_answer_string_2  = "Binary search tree";
        String eight_answer_string_3  = "Extended binary tree";
        String eight_answer_string_4  = "None of above";

        Answer eight_answer_1 = new Answer(eight_answer_string_1);
        Answer eight_answer_2 = new Answer(eight_answer_string_2);
        Answer eight_answer_3 = new Answer(eight_answer_string_3);
        Answer eight_answer_4 = new Answer(eight_answer_string_4);

        ArrayList<Answer> eight_answers = new ArrayList<Answer>();
        eight_answers.add(eight_answer_1);
        eight_answers.add(eight_answer_2);
        eight_answers.add(eight_answer_3);
        eight_answers.add(eight_answer_4);

        Answer eight_correct_answer = eight_answer_3;

        Question q8 = new Question(eight_question, eight_answers, eight_correct_answer);

        // q9
        String nine_question = "The in order traversal of tree will yield a sorted listing of  elements of tree in";
        String nine_answer_string_1  = "Binary trees";
        String nine_answer_string_2  = "Binary search trees";
        String nine_answer_string_3  = "Heaps";
        String nine_answer_string_4  = "None of above";

        Answer nine_answer_1 = new Answer(nine_answer_string_1);
        Answer nine_answer_2 = new Answer(nine_answer_string_2);
        Answer nine_answer_3 = new Answer(nine_answer_string_3);
        Answer nine_answer_4 = new Answer(nine_answer_string_4);

        ArrayList<Answer> nine_answers = new ArrayList<Answer>();
        nine_answers.add(nine_answer_1);
        nine_answers.add(nine_answer_2);
        nine_answers.add(nine_answer_3);
        nine_answers.add(nine_answer_4);

        Answer nine_correct_answer = nine_answer_2;

        Question q9 = new Question(nine_question, nine_answers, nine_correct_answer);

        // q10
        String ten_question = "A binary search tree whose left subtree and right subtree differ in hight by at most 1 unit is called ____";
        String ten_answer_string_1  = "AVL tree";
        String ten_answer_string_2  = "Red-black tree";
        String ten_answer_string_3  = "Lemma tree";
        String ten_answer_string_4  = "None of the above";

        Answer ten_answer_1 = new Answer(ten_answer_string_1);
        Answer ten_answer_2 = new Answer(ten_answer_string_2);
        Answer ten_answer_3 = new Answer(ten_answer_string_3);
        Answer ten_answer_4 = new Answer(ten_answer_string_4);

        ArrayList<Answer> ten_answers = new ArrayList<Answer>();
        ten_answers.add(ten_answer_1);
        ten_answers.add(ten_answer_2);
        ten_answers.add(ten_answer_3);
        ten_answers.add(ten_answer_4);

        Answer ten_correct_answer = ten_answer_1;

        Question q10 = new Question(ten_question, ten_answers, ten_correct_answer);

        ArrayList<Question> qaList = new ArrayList<>();
        qaList.add(q1);
        qaList.add(q2);
        qaList.add(q3);
        qaList.add(q4);
        qaList.add(q5);
        qaList.add(q6);
        qaList.add(q7);
        qaList.add(q8);
        qaList.add(q9);
        qaList.add(q10);

        QuestionStore.defaultBSTStore = qaList;

    }
}