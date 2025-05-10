package LAB_06.EJERCICIOS.Ejercicio4;
import LAB_06.EJERCICIOS.Ejercicio1.*;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

    public class Application {

        public static boolean symbolBalancing(String s) {
            StackLink<Character> stack = new StackLink<>();
    
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']' || ch == '}') {
                    if (stack.isEmpty()) return false;
                    char top;
                    try {
                        top = stack.pop();
                    } catch (ExceptionIsEmpty e) {
                        return false;
                    }
                    if (!matches(top, ch)) return false;
                }
            }
            return stack.isEmpty();
        }
    
        private static boolean matches(char open, char close) {
            return (open == '(' && close == ')') ||
                   (open == '[' && close == ']') ||
                   (open == '{' && close == '}');
        }
    }
