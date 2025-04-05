package tr.com.rest.example.restuserservice.service;

import java.util.List;

import tr.com.rest.example.restuserservice.model.User;

public interface UserService {
//    // Kullanıcı ekleme işlemi
//    public User addUser(String name, String surname);
//
//    // Tüm kullanıcıları getirme işlemi
//    public List<User> getAllUsers();
	
	
	public User addUser(String name, String surname);

	public List<User> getAllUsers();
	
	public List<User> getUsersBySurname(String surname);

	public User getUserById(Long id);

	public User updateUser(Long id, String name, String surname);

	public void deleteUser(Long id);
}
