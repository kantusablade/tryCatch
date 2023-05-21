public class Main {
    public static void main(String[] args) {
        System.out.println(Main.parameters("yukinoxblessed_dxdy", "wannadie","wannadie"));}
    public static boolean parameters(String login, String password, String confirmPassword){
        int a = 0;
        int b = 0;
        String[] symbols = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "1","2","3","4","5","6","7","8","9","0","_"};
        try {
            for (String symbols1 : symbols) {
                if (login.contains(symbols1)) a += 1;
                if (password.contains(symbols1)) b += 1;
            }
            if (a == 0)
                throw new WrongLoginException();
            if (b == 0)
                throw new WrongPasswordException();
            if (login.length() > 20)
                throw new WrongLoginException("Логин должен быть меньше");
            if (password.length() > 20)
                throw new WrongPasswordException("Пароль должен быть меньше");
            if ( !password.equals(confirmPassword))
                throw new WrongPasswordException("Пароли не совпадают, проверьте еще раз");
        }
        catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e);
            return false;
        }
        System.out.println("Пароль и логин введены верно");
        return true;
    }
}