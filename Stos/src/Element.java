public  class Element {
        private Object value;
        private Element next;

        public Element(Object v)
        { setValue(v);
        setNext(null);}

        public void setValue(Object v)
        { value = v;  }

        public Object getValue()
        { return value;   }

        public Element getNext()
        { return next; }

        public void setNext(Element n)
        { next = n; }

        
        public void attachNext(Element pop){
            this.setNext(pop.getNext());
            pop.setNext(this);
        }
        
        
       public void detachNext(){
            this.setNext(this.getNext());

        
    }    
}
