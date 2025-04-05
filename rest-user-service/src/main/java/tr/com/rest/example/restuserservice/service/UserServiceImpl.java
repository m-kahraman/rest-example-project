package tr.com.rest.example.restuserservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tr.com.rest.example.restuserservice.model.User;

@Service
public class UserServiceImpl implements UserService {

	private final List<User> users = new ArrayList<>();
	private Long userIdCounter = 1L;

	@Override
    public User addUser(String name, String surname) {
        // Aynı isim ve soyismine sahip kullanıcıyı kontrol et
        for (User existingUser : users) {
            if (existingUser.getName().equals(name) && existingUser.getSurname().equals(surname)) {
                throw new IllegalArgumentException("Bu kullanıcı zaten mevcut!");
            }
        }

        // Yeni kullanıcı ekleme
        User user = new User();
        user.setId(userIdCounter++);
        user.setName(name);
        user.setSurname(surname);
        users.add(user);
        return user;
    }

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public List<User> getUsersBySurname(String surname) {
		return users.stream()
                .filter(user -> user.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
		return user.orElse(null);
	}

	@Override
	public User updateUser(Long id, String name, String surname) {
		User user = getUserById(id);
		if (user != null) {
			user.setName(name);
			user.setSurname(surname);
		}
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		users.removeIf(user -> user.getId().equals(id));
	}
}
