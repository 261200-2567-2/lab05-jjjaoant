public interface Accessories{
    String getName();
    String getEffect();
}

class Broomstick implements Accessories {
    @Override
    public String getName() {
        return "Broomstick";
    }

    @Override
    public String getEffect() {
        return "Increases speed significantly.";
    }
}

class Wand implements Accessories {
    @Override
    public String getName() {
        return "Wand";
    }

    @Override
    public String getEffect() {
        return "Increases magic damage.";
    }
}

class Boots implements Accessories {
    @Override
    public String getName() {
        return "Boots";
    }

    @Override
    public String getEffect() {
        return "Increases speed.";
    }
}

class Robe implements Accessories {
    @Override
    public String getName() {
        return "Robe";
    }

    @Override
    public String getEffect() {
        return "Increases defense.";
    }
}
