/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Game.Request;

/**
 *
 * @author kduran
 */
public interface ICommand {
    public void execute(Request request);
}
