import gb.list.GBLinkedList;

public class Main {
    public static void main(String[] args) {
        GBLinkedList<Integer> gbLinkedList = new GBLinkedList<>();

        gbLinkedList.add(1).add(2).add(3);
        gbLinkedList.addFirst(4);
        gbLinkedList.addLast(5);

        System.out.println(gbLinkedList);

        gbLinkedList.remove(2);
        System.out.println(gbLinkedList);

        gbLinkedList.removeFirst();
        System.out.println(gbLinkedList);

        gbLinkedList.removeLast();
        System.out.println(gbLinkedList);

        gbLinkedList.update(0, 10);
        System.out.println(gbLinkedList);

        System.out.println(gbLinkedList.size());
        System.out.println(gbLinkedList.get(0));
    }
}