
package com.mycompany.matrices;


public class MATRICES {
    public static void main(String[] args) {
        // Iniciar la ventana de la interfaz gráfica
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vistamatriz().setVisible(true);
            }
        });
    }
}
