package kr.chandol.java8inaction.chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class subChapter2 {

    public static class 전략패턴_BEFORE {
        interface ValidationStrategy {
            boolean execute(String s);
        }

        static class IsAllLowerCase implements ValidationStrategy {
            public boolean execute(String s) {
                return s.matches("[a-z]+]");
            }
        }

        static class IsNumeric implements ValidationStrategy {
            public boolean execute(String s) {
                return s.matches("\\d+");
            }
        }

        static class Validator {
            private final ValidationStrategy strategy;

            public Validator(ValidationStrategy v) {
                this.strategy = v;
            }

            public boolean validate(String s) {
                return strategy.execute(s);
            }
        }

        public static void main(String[] args) {
            Validator aa = new Validator(new IsNumeric());
            boolean b1 = aa.validate("aaaaaaaa");
            System.out.println(b1);

            Validator bb = new Validator(new IsAllLowerCase());
            boolean b2 = bb.validate("bbbbb");
            System.out.println(b2);
        }
    }

    public static class 전략패턴_AFTER {
        interface ValidationStrategy {
            boolean execute(String s);
        }

        static class Validator {
            private final ValidationStrategy strategy;

            public Validator(ValidationStrategy v) {
                this.strategy = v;
            }

            public boolean validate(String s) {
                return strategy.execute(s);
            }
        }


        public static void main(String[] args) {
            Validator aa = new Validator((s) -> s.matches("[a-z]+]"));
            boolean b1 = aa.validate("aaaaaaaa");
            System.out.println(b1);

            Validator bb = new Validator((s) -> s.matches("\\d+"));
            boolean b2 = bb.validate("bbbbb");
            System.out.println(b2);
        }
    }

    static class 템플릿메서드_before {
        static class Customer {
        }

        abstract static class OnlineBanking {
            public void processCustomer(int id) {
                Customer c = new Customer();
                makeCustomerHappy(c);
            }

            abstract void makeCustomerHappy(Customer c);
        }

        public static void main(String[] args) {
            OnlineBanking onlineBanking = new OnlineBanking() {
                @Override
                void makeCustomerHappy(Customer c) {
                    System.out.println("Hello " + c);
                }
            };
        }
    }

    static class 템플릿메서드_after {
        static class Customer {
        }

        static class OnlineBanking {
            public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
                Customer c = new Customer();
                makeCustomerHappy.accept(c);
            }
        }

        public static void main(String[] args) {
            new OnlineBanking().processCustomer(0, (c) -> System.out.println("Hello" + c));
        }
    }

    static class 옵저버패턴 {
        interface Subject {
            void registerObserver(Observer o);

            void notifyObservers(String tweet);
        }

        static private class Feed implements Subject {
            private final List<Observer> observers = new ArrayList<>();

            public void registerObserver(Observer o) {
                this.observers.add(o);
            }

            public void notifyObservers(String tweet) {
                observers.forEach(o -> o.inform(tweet));
            }
        }

        interface Observer {
            void inform(String tweet);
        }


        static private class NYTimes implements Observer {
            @Override
            public void inform(String tweet) {
                if (tweet != null && tweet.contains("money")) {
                    System.out.println("Breaking news in NY!" + tweet);
                }
            }
        }

        static private class Guardian implements Observer {
            @Override
            public void inform(String tweet) {
                if (tweet != null && tweet.contains("queen")) {
                    System.out.println("Yet another news in London... " + tweet);
                }
            }
        }

        public static void main(String[] args) {
            Feed f = new Feed();
            f.registerObserver(new NYTimes());
            f.registerObserver(new Guardian());
            f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

            Feed feedLambda = new Feed();

            feedLambda.registerObserver((String tweet) -> {
                if (tweet != null && tweet.contains("money")) {
                    System.out.println("Breaking news in NY! " + tweet);
                }
            });
            feedLambda.registerObserver((String tweet) -> {
                if (tweet != null && tweet.contains("queen")) {
                    System.out.println("Yet another news in London... " + tweet);
                }
            });

            feedLambda.notifyObservers("Money money money, give me money!");
        }
    }


}
