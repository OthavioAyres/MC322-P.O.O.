package lab3ex2;

public enum Operacao implements Calcula {
    SOMA {
        @Override
        public double calcula(int a, int b) {
            return a + b;
        }
    },
    SUBTRACAO {
        @Override
        public double calcula(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICACAO {
        @Override
        public double calcula(int a, int b) {
            return a * b;
        }
    },
    DIVISAO {
        @Override
        public double calcula(int a, int b) {
            return a / b;
        }
    };
}

