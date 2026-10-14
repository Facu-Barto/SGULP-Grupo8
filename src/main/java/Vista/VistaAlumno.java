package Vista;

import Modelo.Alumno;
import Persistencia.AlumnoData;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaAlumno extends javax.swing.JInternalFrame {
    
    private AlumnoData alumnoData;
    private DefaultTableModel modeloTabla;

    public VistaAlumno() {
        initComponents();
        alumnoData = new AlumnoData();
        modeloTabla = (DefaultTableModel) tableAlumnos.getModel();
        
        cargarTabla();
    }
    
    //Carga la tabla con los datos de la base de datos.
    private void cargarTabla(){
        modeloTabla.setRowCount(0); //Esto borra visualmente las filas para que no se dupliquen las filas si llamas a un metodo mas de una vez. 
    
        List<Alumno> listaAlumnos = alumnoData.listarAlumnos();
    
        for (Alumno a : listaAlumnos) {
            modeloTabla.addRow(new Object[]{
                a.getId_alumno(),
                a.getDni(),
                a.getApellido(),
                a.getNombre(),
                a.getFecha_nacimiento(),
                a.isActivo() ? "Activo" : "Inactivo" 
            });
        }
    }
    
    //Este metodo vacia todos los campos.
    private void limpiarCampos() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNacimiento.setText("");
        rbtnActivo.setSelected(true);
        
        //Estas lienas son para evitar que el usuario toque Actualizar o Eliminar cuando no selecciono a nadie de la tabla.
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        //Deselecciona cualquier alumno que el usario agarro en la tabla para que no muestre mas sus datos.
        tableAlumnos.clearSelection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupActivo = new javax.swing.ButtonGroup();
        PanelGeneral = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelDni = new javax.swing.JLabel();
        labelFechaNacimiento = new javax.swing.JLabel();
        labelActivo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        rbtnActivo = new javax.swing.JRadioButton();
        rbtnInactivo = new javax.swing.JRadioButton();
        PanelBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        PanelTable = new javax.swing.JPanel();
        ScrollPanelTable = new javax.swing.JScrollPane();
        tableAlumnos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Titulo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        labelNombre.setText("Nombre:");

        labelApellido.setText("Apellido:");

        labelDni.setText("DNI:");

        labelFechaNacimiento.setText("Fecha Nacimiento:");

        labelActivo.setText("Activo:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnGroupActivo.add(rbtnActivo);
        rbtnActivo.setText("Activo");

        btnGroupActivo.add(rbtnInactivo);
        rbtnInactivo.setText("Inactivo");

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDni, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelApellido, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelActivo)
                            .addComponent(labelFechaNacimiento))
                        .addGap(18, 18, 18)))
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(btnBuscar))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(rbtnActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnInactivo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar))
                    .addComponent(labelDni))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApellido))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFechaNacimiento))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelActivo)
                    .addComponent(rbtnActivo)
                    .addComponent(rbtnInactivo))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotonesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        PanelBotonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnEliminar, btnGuardar, btnLimpiar});

        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnLimpiar))
                .addGap(38, 38, 38))
        );

        PanelBotonesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar, btnEliminar, btnGuardar, btnLimpiar});

        tableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellido", "Fecha Nacimiento", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlumnosMouseClicked(evt);
            }
        });
        ScrollPanelTable.setViewportView(tableAlumnos);

        javax.swing.GroupLayout PanelTableLayout = new javax.swing.GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPanelTable)
                .addContainerGap())
        );
        PanelTableLayout.setVerticalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Gestionar Alumnos");

        javax.swing.GroupLayout PanelGeneralLayout = new javax.swing.GroupLayout(PanelGeneral);
        PanelGeneral.setLayout(PanelGeneralLayout);
        PanelGeneralLayout.setHorizontalGroup(
            PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        PanelGeneralLayout.setVerticalGroup(
            PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Primero validamos que el campo este correcto
        if (txtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Debe colocar el DNI del alumno.","Campo Vacío",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            //Convertimos el texto a un numero
            int dni = Integer.parseInt(txtDni.getText());
        
            //Consultamos a la base de datos con el metodo adecuado
            Alumno alumnoEncontrado = alumnoData.buscarAlumno(dni);
        
            //Vemos si la base de datos nos devolvio un alumno o no
            if (alumnoEncontrado != null) {
                //Llenamoss los campos con la informacion dada
                txtApellido.setText(alumnoEncontrado.getApellido());
                txtNombre.setText(alumnoEncontrado.getNombre());
                txtFechaNacimiento.setText(alumnoEncontrado.getFecha_nacimiento().toString());
                
                if (alumnoEncontrado.isActivo()) {
                    rbtnActivo.setSelected(true);
                } else {
                    rbtnInactivo.setSelected(true);
                }
                
            } else { 
                JOptionPane.showMessageDialog(this,"No se encontró ningún alumno con el DNI ingresado.","Sin Resultados",JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (NumberFormatException ex){ // Se ejecuta si el usuario ingresó letras o símbolos en el DNI
            JOptionPane.showMessageDialog(this,"El DNI debe ser solo números.","Error de Formato",JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validamos los campos.
        if (txtDni.getText().isEmpty() || txtApellido.getText().isEmpty() || txtNombre.getText().isEmpty() || txtFechaNacimiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Debes llenar todos los campos.","Campos Vacíos",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            //Manejamos los datos ingresados. El dni se parsea, la fecha se convierte a localDate.
            int dni = Integer.parseInt(txtDni.getText());
            String apellido = txtApellido.getText();
            String nombre = txtNombre.getText();
            LocalDate fechaNacimiento = LocalDate.parse(txtFechaNacimiento.getText());
            boolean activo = rbtnActivo.isSelected();

            //Creamos y guardamos el nuevo Alumno sin ID porque SQL lo genera solo.
            Alumno nuevoAlumno = new Alumno(dni, apellido, nombre, fechaNacimiento, activo);
            alumnoData.guardarAlumno(nuevoAlumno);

            //Limpiamos los campos y recargamos la tabla
            limpiarCampos();
            cargarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"El DNI debe ser solo números.","Error de Formato",JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,"La fecha debe tener el formato AAAA-MM-DD (ejemplo: 2026-01-01).","Error de Fecha",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tableAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlumnosMouseClicked
        int filaSeleccionada = tableAlumnos.getSelectedRow();

        if (filaSeleccionada != -1) {
            
            //Leemos cada celda de la fila usando getValueAt(fila, columna) y pasamos a String
            txtDni.setText(tableAlumnos.getValueAt(filaSeleccionada, 1).toString());
            txtApellido.setText(tableAlumnos.getValueAt(filaSeleccionada, 2).toString());
            txtNombre.setText(tableAlumnos.getValueAt(filaSeleccionada, 3).toString());
            txtFechaNacimiento.setText(tableAlumnos.getValueAt(filaSeleccionada, 4).toString());
            
            //Evaluamos la columna de activo para marcar el RadioButton
            String activo = tableAlumnos.getValueAt(filaSeleccionada, 5).toString();
            
            //Para evitar que el usuario toque guardar cuando selecciona un alumno de la tabla
            btnGuardar.setEnabled(false);
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
            if (activo.equals("Activo")) {
                rbtnActivo.setSelected(true);
            } else {
                rbtnInactivo.setSelected(true);
            }
        }
    }//GEN-LAST:event_tableAlumnosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Verificamos que se haya seleccionado una fila de la tabla.
        int filaSeleccionada = tableAlumnos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,"Debe seleccionar un alumno de la tabla para actualizar sus datos.","Ningún alumno seleccionado",JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Validamos los campos.
        if (txtDni.getText().isEmpty() || txtApellido.getText().isEmpty() || txtNombre.getText().isEmpty() || txtFechaNacimiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Debes llenar todos los campos.","Campos Vacíos",JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            //Obtenemos el id_alumno de la primera columna(0).
            int idAlumno = (int) tableAlumnos.getValueAt(filaSeleccionada, 0);

            //Leemos los campos modificados
            int dni = Integer.parseInt(txtDni.getText());
            String apellido = txtApellido.getText();
            String nombre = txtNombre.getText();
            LocalDate fechaNacimiento = LocalDate.parse(txtFechaNacimiento.getText());
            boolean activo = rbtnActivo.isSelected();

            //Creamos el objeto Alumno usando el constructor que si tiene id.
            Alumno alumnoModificado = new Alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, activo);

            //Enviamos el alumno actualizado a la base de datos.
            alumnoData.actualizarAlumno(alumnoModificado);

            //Limpiamos los campos y recargamos la tabla.
            limpiarCampos();
            cargarTabla();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"El Dni debe ser solo números.","Error de Formato",JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,"La fecha debe tener el formato AAAA-MM-DD.","Error de Fecha",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Verificamos si hay un alumno seleccionado en la tabla.
        int filaSeleccionada = tableAlumnos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,"Debe seleccionar un alumno de la tabla para eliminarlo.","Ningún alumno seleccionado",JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Pedimos confirmación antes de borrar.
        int respuesta = JOptionPane.showConfirmDialog(this,"¿Estás seguro de que queres eliminar al alumno seleccionado?","Confirmar Eliminación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        //Si se confirma:
        if (respuesta == JOptionPane.YES_OPTION) {
            //Obtenemos el id_alumno de la primera columna(0).
            int idAlumno = (int) tableAlumnos.getValueAt(filaSeleccionada, 0);
            alumnoData.bajaLogicaAlumno(idAlumno);

            //Limpiamos los campos y recargamos la tabla.
            limpiarCampos();
            cargarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelGeneral;
    private javax.swing.JPanel PanelTable;
    private javax.swing.JScrollPane ScrollPanelTable;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGroupActivo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelActivo;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelDni;
    private javax.swing.JLabel labelFechaNacimiento;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnInactivo;
    private javax.swing.JTable tableAlumnos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
