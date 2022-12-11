package DailyRiddles.Day3;

public class Rucksack {
    String[] compartments;
    String contents;
    char commonItem;
    int priority;
    char badge;
    int badgePriority;

    public Rucksack(String contents) {
        this.contents = contents;
    }

    public void splitContents() {
        int mid = this.contents.length()/2;
        this.compartments = new String[]{this.contents.substring(0, mid), this.contents.substring(mid)};
    }

    public void findCommonItem() {
        for (int i = 0; i < this.compartments[0].length(); i++){
            char letterFirstHalf = this.compartments[0].charAt(i);
            for (int j = 0; j < this.compartments[0].length(); j++){
                char letterSecondHalf = this.compartments[1].charAt(j);
                if (letterFirstHalf == letterSecondHalf){
                    this.commonItem = letterFirstHalf;
                    return;
                }
            }
        }
    }


    public void determinePriority() {
        if (this.commonItem >= 97 && this.commonItem <= 122){
            this.priority = this.commonItem - 96;
        } else {
            this.priority = this.commonItem - 38;
        }
    }


    public void determineBadgePriority() {
        if (this.badge >= 97 && this.badge <= 122){
            this.badgePriority = this.badge - 96;
        } else {
            this.badgePriority = this.badge - 38;
        }
    }


    public void printInfo() {
        System.out.println("Contents: " + this.contents);
        System.out.println("Compartments: " + this.compartments[0] + " and " + this.compartments[1]);
        System.out.println("Common item: " + this.commonItem);
        System.out.println("Determined priority: " + this.priority);
        System.out.println("Badge: " + this.badge);
        System.out.println("Badge priority: " + this.badgePriority);
    }
}
