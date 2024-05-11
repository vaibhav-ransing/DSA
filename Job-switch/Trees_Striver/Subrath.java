public class Subrath {

    public void helper(){
        
    }

    public static void main(String[] args) {
        DB dbObj = DB.createDBObject();  // obj
        dbObj.reduceQty(10);
        dbObj.reduceQty(10);

        DB dbObj2 = DB.createDBObject();  // obj
        dbObj2.reduceQty(5);
        
    }
}

class DB {

    private static DB dbObj;

    private DB() {
    }

    static DB createDBObject() {
        if(dbObj == null){
            dbObj = new DB();
        }
        return dbObj;
    }

    int qty = 15;

    void reduceQty(int askedQty) {
        // go to db and reduce quty by qty
        if (this.qty > askedQty) {
            this.qty = this.qty - askedQty;
            System.out.println("Quantiry reduce by " + askedQty);
        } else {
            System.out.println("Not enough of " + askedQty);
        }
    }
}