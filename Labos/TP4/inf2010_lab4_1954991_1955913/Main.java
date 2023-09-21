import java.lang.reflect.Array;
import java.util.*;


public class Main
{
   /**
    * Fonction principale
    */
   public static void main(String[] args)
   {
      // Creer un monceau avec 22 éléments et un tableau équivalent
      int numItems = 22;
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);

      Integer [ ] items = new Integer[ numItems ];

      int i;
      int j;

      // En insérant les éléments un a un
      for( i = 11, j = 0; j != numItems; i = ( i + 37 ), j++ )
      {
         heap.offer( i );
         items[ j ] = i;

         i %=  numItems;
      }


      // en construisant le monceau depuis le depart
      System.out.println("Monceau min contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(false);
      // en inserant les elements un a un
      for( Integer item : items)
         heap.offer( item );

      // en construisant le monceau depuis le depart
      System.out.println("Monceau max contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,false);
      System.out.println("Monceau max contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,true);
      System.out.println("Monceau min contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      System.out.println();
      System.out.println("Affichage recursif:");
      System.out.println( heap.printFancyTree() );

      System.out.println("Affichage non recursif:");
      System.out.println( heap.nonRecursivePrintFancyTree() );

      System.out.println();
      System.out.println("Tableau d'origine:");
      System.out.println( printArray( items ) );

      BinaryHeap.heapSort( items );
      System.out.println("Tableau ordonne:");
      System.out.println( printArray( items ) );

      BinaryHeap.heapSortReverse( items );
      System.out.println("Tableau inversement ordonne:");
      System.out.println( printArray( items ) );


      /*
       * Ajouter appels pour repondre a la question
       **/






      System.out.println("\n****\nTEST\n****");

      PriorityQueue<Integer> priorityQueueTest = new PriorityQueue<>();
      BinaryHeap<Integer>  heapTest = new BinaryHeap<>(true);
      for (Integer item : items){
         priorityQueueTest.offer(item);
         heapTest.offer(item);
      }
      boolean pollWorks = true;
      for (int k = 0; k < heapTest.size(); k++) {
         if (!priorityQueueTest.poll().equals(heapTest.poll()) || !priorityQueueTest.peek().equals(heapTest.peek())) {
            pollWorks = false;
            break;
         }
      }
      if (pollWorks){
         System.out.println("La fonction poll() fonctionne, car elle retire le premier element");
         System.out.println("On peut aussi conclure que les fonctions offer(), builMinHeap(), percolateDownMinHeap() et peek(), fonctionne car le heap est rajuste");
      } else {
         System.out.println("La fonction poll() ou peek() ne fonction pas");
      }

      Iterator<Integer> itHeap = heapTest.iterator();
      Iterator<Integer> itPQ = priorityQueueTest.iterator();
      boolean iteratorWorks = true;
      Integer s;
      Integer t;
      while (itHeap.hasNext() && itPQ.hasNext()) {
         if (itHeap.hasNext() && itPQ.hasNext()) {
            if (!itHeap.next().equals(itPQ.next())) {
               iteratorWorks = false;
               break;
            }
         }
      }
      if (iteratorWorks){
         System.out.println("La fonction next() fonctionne");
      } else {
         System.out.println("La fonction next() ne fonctionne pas");
      }

      itHeap = heapTest.iterator();
      itHeap.next();
      heapTest.offer(1);
      try {
         itHeap.next();
      } catch (ConcurrentModificationException e) {
         System.out.println("L'iterateur est fail-fast");
      }

      BinaryHeap<Integer> maxHeap = new BinaryHeap<>(items, false);
      boolean maxHeapWorks = true;
      int max;
      int prevMax = Integer.MAX_VALUE;
      for (int k = 0; k < maxHeap.size(); k++) {
         max = maxHeap.poll();
         if (max > prevMax){
            maxHeapWorks = false;
            break;
         }
         prevMax = max;
      }
      if (maxHeapWorks){
         System.out.println("La fonction buildMaxHeap() et percolateDownMaxHeap() fonctionne");
      } else {
         System.out.println("La fonction buildMaxHeap() ou percolateDownMaxHeap() ne fonctionne pas");
      }
   }

   private static <AnyType> String printArray(AnyType[] a)
   {
      String outputString = "";

      for(AnyType item : a)
      {
         outputString += item;
         outputString += ", ";
      }

      return outputString.substring(0,outputString.length()-2);
   }
}
