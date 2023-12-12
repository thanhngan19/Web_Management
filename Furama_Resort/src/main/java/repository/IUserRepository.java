package repository;

import model.User;

public interface IUserRepository {
 boolean checkPass(User userCheck);
}
