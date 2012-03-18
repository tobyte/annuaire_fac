/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Users;
import java.util.List;

/**
 *
 * @author 10702274
 */

public interface IDao {
     public List<Users> findAll();

}
