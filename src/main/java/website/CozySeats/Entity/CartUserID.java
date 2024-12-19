package website.CozySeats.Entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CartUserID  implements Serializable{
    

    private Long cartID;

    private Long userID;
}
