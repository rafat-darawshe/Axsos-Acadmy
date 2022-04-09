class Ninja{
    constructor(name){
        this.name = name;
        this.health = 50;
        this.speed = 3;
        this.strength = 3;
    }
    sayName(){
        console.log(this.name)
    }

    showStats(){
        console.log(`Name: ${this.name}`);
        console.log(`Strength: ${this.strength}`);
        console.log(`Speed: ${this.speed}`);
        console.log(`Health: ${this.health}`);
        
    }
    drinkSake(){
        this.health += 10;
    }

}

class Sensei extends Ninja{
    constructor(name){
        super(name);
        this.wisdom = 20;
        this.health = 300;
        this.speed = 15;
        this.strength = 15;
    }
    speakWisdom(){
        this.drinkSake();
        console.log("wise message")
    }
}
const sensei1 = new Sensei("Rafat");
sensei1.showStats();
sensei1.speakWisdom();
sensei1.showStats();
