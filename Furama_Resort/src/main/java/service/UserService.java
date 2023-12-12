package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

public class UserService implements IUserService{
    private IUserRepository repo= new UserRepository();
    @Override
    public boolean checkPass(User userCheck) {
        return repo.checkPass(userCheck);
    }
}
