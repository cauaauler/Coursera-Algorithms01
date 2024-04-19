import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

            private Node first;
            private Node last;
            private int size;

            private class Node {
                Item item;
                Node next;
                Node prev;
            }

            // construct an empty deque
            public Deque(){
                first = null;
                last = null;
                size = 0;
            }

            // is the deque empty?
            public boolean isEmpty()
            {   return size == 0;   }

            // return the number of items on the deque
            public int size()
            {   return size;    }

            // add the item to the front
            public void addFirst(Item item)
            {
                if (item == null) {
                    throw new IllegalArgumentException("Item cannot be null");
                }
                Node newFirst = new Node();
                newFirst.item = item;
                if (isEmpty()) {
                    first = newFirst;
                    last = newFirst;
                } else {
                    newFirst.next = first;
                    first.prev = newFirst;
                    first = newFirst;
                }
                size++;
            }

            // add the item to the back
            public void addLast(Item item)
            {
                if (item == null) {
                    throw new IllegalArgumentException("Item cannot be null");
                }
                Node newLast = new Node();
                newLast.item = item;
                if(isEmpty()) {
                    last = newLast;
                    first = newLast;
                }else {
                    newLast.prev = last;
                    last.next = newLast;
                    last = newLast;
                }
                size++;
            }


            // remove and return the item from the front
            public Item removeFirst()
            {
                if (isEmpty()) {
                    throw new NoSuchElementException("Deque is empty");
                }
                Item item = first.item;
                first = first.next;
                if (first != null) {
                    //first.prev é o antigo first
                    first.prev = null;
                }else {
                    last = null; // Se o deque ficar vazio após a remoção
                }
                size--;
                return item;

            }


            // remove and return the item from the back
            public Item removeLast()
            {
                if (isEmpty()) {
                    throw new NoSuchElementException("Deque is empty");
                }
                Item item = last.item;
                last = last.prev;
                if (last != null) {
                    //last.next é o antigo last
                    last.next = null;
                }else {
                    first = null;
                }
                size--;
                return item;
            }

            // return an iterator over items in order from front to back
            public Iterator<Item> iterator() {
                return new DequeIterator();
            }

                private class DequeIterator implements Iterator<Item> {
                    private Node current = first;

                    public boolean hasNext() {
                        return current != null;
                    }

                    public Item next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        Item item = current.item;
                        current = current.next;
                        return item;
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                }


    // unit testing (required)
    public static void main(String[] args) {
        // Cria um deque de caracteres
        Deque<Character> deque = new Deque<>();

        // Verifica se o deque está vazio
        StdOut.println("Deque está vazio? " + deque.isEmpty());

        // Adiciona elementos ao deque
        deque.addFirst('a');
        deque.addLast('b');

        // Cria um iterator para o deque
        Iterator<Character> iterator = deque.iterator();

        // Itera sobre os elementos do deque usando o iterator
        while (iterator.hasNext()) {
            Character item = iterator.next();
            StdOut.println("Elemento do deque: " + item);
        }

        // Verifica se o deque está vazio novamente
        StdOut.println("Deque está vazio? " + deque.isEmpty());

        // Imprime o tamanho do deque
        StdOut.println("Tamanho do deque: " + deque.size());

        // Adiciona e remove elementos do deque
        deque.addLast('c');

        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();

        // Verifica se o deque está vazio e imprime o tamanho novamente
        StdOut.println("Deque está vazio? " + deque.isEmpty());
        StdOut.println("Tamanho do deque: " + deque.size());
    }



}

