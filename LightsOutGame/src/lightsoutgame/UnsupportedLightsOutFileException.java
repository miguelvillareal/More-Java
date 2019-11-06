/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsoutgame;

/**
 * This file is the exception class for an unsupported save file. It is an
 * extension of the Exception class Invalid File Format.
 * @author Miguel Villareal
 *
 */
public class UnsupportedLightsOutFileException extends Exception {
    public UnsupportedLightsOutFileException() {super("Invalid File Format");}
}
