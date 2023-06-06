package app;

public class ACounter implements AutoCloseable {
        private int count;
      
        public void add() {
          this.count++;
        }
      
        public int getCount() {
          return count;
        }
      
        public void resetCount() {
          this.count = 0;
        }

        @Override
        public void close() throws Exception {
            // TODO Auto-generated method stub
            // throw new UnsupportedOperationException("Unimplemented method 'close'");
        }
}
