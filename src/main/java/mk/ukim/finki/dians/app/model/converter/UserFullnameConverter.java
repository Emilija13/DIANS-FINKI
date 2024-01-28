package mk.ukim.finki.dians.app.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import mk.ukim.finki.dians.app.model.UserFullname;

@Converter(autoApply = true)
public class UserFullnameConverter implements AttributeConverter<UserFullname, String> {
    @Override
    public String convertToDatabaseColumn(UserFullname attribute) {
        return attribute != null ? attribute.getName() + " " + attribute.getSurname() : null;
    }

    @Override
    public UserFullname convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            String[] parts = dbData.split(" ");
            return new UserFullname(parts[0], parts[1]);
        }
        return null;
    }
}
