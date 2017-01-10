class IntTree {
    
    private class Node {
        
        int elem;
        Node left = null;
        Node right = null;
        
        Node(int elem) {
            this.elem = elem;
        }
        
        void add(int elem) {
            if (elem < this.elem) {
                if (this.left == null) {
                    this.left = new Node(elem);
                } else {
                    this.left.add(elem);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(elem);
                } else {
                    this.right.add(elem);
                }
            }
        }

        /**
         * Liefert die Anzahl aller Knoten im Baum zurück. Wird
         * ohne Parameter aufgerufen.
         *
         * @return
         */
        int countNodes() {

            return -1;
        }
        
        int countLeaves() {
            //TODO Implementieren Sie hier die Angabe
            return -1; //diese Anweisung ändern oder löschen.
        }
        
        int height() {
            //TODO Implementieren Sie hier die Angabe
            return -1; //diese Anweisung ändern oder löschen.
        }
        
        void printLeaves() {
            //TODO Implementieren Sie hier die Angabe
        }
        
        void printInOrderUp() {
            //TODO Implementieren Sie hier die Angabe
        }
        
        void printInOrderUpSub(int elem) {
            //TODO Implementieren Sie hier die Angabe
        }
    
        void printPostOrder() {
            //TODO Implementieren Sie hier die Angabe
        }
    
        void printPreOrder() {
            //TODO Implementieren Sie hier die Angabe
        }
    }
    
    private Node root = null;
    
    public void add(int elem) {
        if (empty()) {
            this.root = new Node(elem);
        } else {
            this.root.add(elem);
        }
    }
    
    public boolean empty() {
        return this.root == null;
    }
    
    public int countNodes() {
        //TODO Implementieren Sie hier die Angabe
        return -1; //diese Anweisung ändern oder löschen.
    }
    
    public int countLeaves() {
        //TODO Implementieren Sie hier die Angabe
        return -1; //diese Anweisung ändern oder löschen.
    }
    
    public int height() {
        //TODO Implementieren Sie hier die Angabe
        return -1; //diese Anweisung ändern oder löschen.
    }
    
    public void printLeaves() {
        //TODO Implementieren Sie hier die Angabe
    }
    
    public void printInOrderUp() {
        //TODO Implementieren Sie hier die Angabe
    }
    
    public void printInOrderUpSub(int elem) {
        //TODO Implementieren Sie hier die Angabe
    }
    
    public void printPostOrder(){
        //TODO Implementieren Sie hier die Angabe
    }
    
    public void printPreOrder(){
        //TODO Implementieren Sie hier die Angabe
    }
}
