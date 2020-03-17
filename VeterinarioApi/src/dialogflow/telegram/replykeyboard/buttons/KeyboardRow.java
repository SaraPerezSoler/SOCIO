package dialogflow.telegram.replykeyboard.buttons;


import java.util.ArrayList;

public class KeyboardRow extends ArrayList<KeyboardButton> {
  
	private static final long serialVersionUID = 1L;

	public boolean add(String text) {
        return super.add(new KeyboardButton(text));
    }

    public void add(int index, String text) {
        super.add(index, new KeyboardButton(text));
    }

    public boolean contains(String text) {
        return super.contains(new KeyboardButton(text));
    }

    public int lastIndexOf(String text) {
        return super.lastIndexOf(new KeyboardButton(text));
    }

    public int indexOf(String text) {
        return super.indexOf(new KeyboardButton(text));
    }

    public KeyboardButton set(int index, String text) {
        return super.set(index, new KeyboardButton(text));
    }

    public boolean remove(String text) {
        return super.remove(new KeyboardButton(text));
    }
    
    
}
