package ejercicio1;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int cant = 0;
		if (this.getData() == null) {
			return cant;
		}
		else
			if(this.isLeaf()) {
				cant += 1; 
			}
			else {
				if(this.hasLeftChild()) {
					cant += this.getLeftChild().contarHojas(); //SE SUMA A CANT
				}
				if(this.hasRightChild()) {
					cant += this.getRightChild().contarHojas(); //SE SUMA A CANT
				}
			}
		return cant;
	}
		
    public BinaryTree<T> espejo(){
    	BinaryTree<T> arbolEspejo = new BinaryTree<>(this.getData());
    	if (this.hasLeftChild()) {
            arbolEspejo.addRightChild(this.getLeftChild().espejo());
        }
        if (this.hasRightChild()) {
            arbolEspejo.addLeftChild(this.getRightChild().espejo());
        }
        return arbolEspejo;
    }

	public void entreNiveles(int n, int m){
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		BinaryTree<T> nodo;
		int nivelActual = 0;
		while (!cola.isEmpty()) {
			nodo = cola.dequeue();
			if(nodo != null) {
				if(nivelActual >= n && nivelActual <= m) {
					System.out.println(nodo.getData().toString());
				}
				if(nodo.hasLeftChild()) {
					cola.enqueue(nodo.getLeftChild());
				}
				if(nodo.hasRightChild()) {
					cola.enqueue(nodo.getRightChild());
				}
			}
			else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					nivelActual++;
				}
			}

		}
   }
	
	public void imprimirArbol() {
        imprimirRecursivo(this, 0);
    }

    private void imprimirRecursivo(BinaryTree<T> nodo, int nivel) {
        if (nodo == null || nodo.isEmpty()) return;

        // Primero imprime el hijo derecho
        imprimirRecursivo(nodo.getRightChild(), nivel + 1);

        // Imprime el dato con indentación
        for (int i = 0; i < nivel; i++) System.out.print("   ");
        System.out.println(nodo.getData());

        // Después imprime el hijo izquierdo
        imprimirRecursivo(nodo.getLeftChild(), nivel + 1);
    }
		
}

