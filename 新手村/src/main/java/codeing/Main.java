package codeing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从一个字符串中找到第一个不重复的字符，返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Main {


    public static void main(String[] args) {
        String[][] operators = {{"add", "cat", "1"}, {"add", "dog", "2"}, {"pollAll"}, {"isEmpty"}, {"add", "cat", "5"}, {"isDogEmpty"}, {"pollCat"}, {"add", "dog", "10"}, {"add", "cat", "199"}, {"pollDog"}, {"pollAll"}};
        new Main().cardogqueue(operators);
    }

    /**
     * 偶数位翻转
     *
     * @param
     * @return
     */

    public String[] cardogqueue(String[][] operators) {
        LinkedList<String> result = new LinkedList<>();
        DogCatQuene dogCatQuene = new DogCatQuene();
        for (int i = 0; i < operators.length; i++) {
            String[] operator = operators[i];
            if (operator.length == 1) {
                if (operator[0].equals("pollAll")) {
                    PetEnterQuene pet = dogCatQuene.pollAll();
                    result.add(pet.getPet().getPetType() + " " + pet.getCount());
                } else if (operator[0].equals("pollDog")) {
                    PetEnterQuene pet = dogCatQuene.pollDog();
                    result.add(pet.getPet().getPetType() + " " + pet.getCount());
                } else if (operator[0].equals("pollCat")) {
                    PetEnterQuene pet = dogCatQuene.pollCat();
                    result.add(pet.getPet().getPetType() + " " + pet.getCount());
                } else if (operator[0].equals("isEmpty")) {
                    if (dogCatQuene.isEmpty()) {
                        result.add("yes");
                    } else {
                        result.add("no");
                    }
                } else if (operator[0].equals("isDogEmpty")) {
                    if (dogCatQuene.isDogEmpty()) {
                        result.add("yes");
                    } else {
                        result.add("no");
                    }
                } else if (operator[0].equals("isCatEmpty")) {
                    if (dogCatQuene.isCatEmpty()) {
                        result.add("yes");
                    } else {
                        result.add("no");
                    }
                }
            }
            if (operator.length == 3) {
                for (int j = 0; j < operator.length; j++) {
                    String operate = operator[0];
                    String petType = operator[1];
                    Long count = Long.valueOf(operator[2]);
                    if (operate.equals("add")) {
                        if (petType.equals("cat")) {

                            dogCatQuene.add(new Cat(),count);
                        } else if (petType.equals("dog")) {
                            dogCatQuene.add(new Dog(),count);
                        }
                    }

                }
            }
            for (String s : result.toArray(new String[0])) {
                System.out.println(s);
            }
        }
        return result.toArray(new String[0]);
    }


    public class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return type;
        }
    }

    public class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public class PetEnterQuene {
        private Pet pet;
        private long count;

        public PetEnterQuene(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }
    }

    public class DogCatQuene {
        private Queue<PetEnterQuene> dogQ;
        private Queue<PetEnterQuene> catQ;
        private long count;

        public DogCatQuene() {
            this.dogQ = new LinkedList<PetEnterQuene>();
            this.catQ = new LinkedList<PetEnterQuene>();
            this.count = 0;
        }

        public void add(Pet pet, long count) {
            if (pet.getPetType().equals("dog")) {
                this.dogQ.add(new PetEnterQuene(pet, count));
            } else if (pet.getPetType().equals("cat")) {
                this.catQ.add(new PetEnterQuene(pet, count));
            } else {
                throw new RuntimeException("error");
            }
        }

        public PetEnterQuene pollAll() {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll();
                } else {
                    return this.catQ.poll();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll();
            } else {
                throw new RuntimeException("error");
            }
        }

        public PetEnterQuene pollDog() {
            if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll();
            } else {
                throw new RuntimeException("error");
            }
        }

        public PetEnterQuene pollCat() {
            if (!this.catQ.isEmpty()) {
                return this.catQ.poll();
            } else {
                throw new RuntimeException("error");
            }
        }

        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        public boolean isDogEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatEmpty() {
            return this.catQ.isEmpty();
        }

    }

}
