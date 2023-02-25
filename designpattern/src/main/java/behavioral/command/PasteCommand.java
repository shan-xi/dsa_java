package behavioral.command;

public class PasteCommand extends Command {
    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) {
            return false;
        }
        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }

    public PasteCommand(Editor editor) {
        super(editor);
    }
}
