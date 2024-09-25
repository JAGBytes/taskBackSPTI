# Laboratorio 04- SCRUM - DI/IOC - INTERNET
*Integrantes:*

*-Andrea Camila Torres Gonzales.*

*-Jorge Andrés Gamboa Sierra.*

*-Jaider David Vargas Noriega.*

*-Laura Sofia Gil Chaves.*

## Bitacora taskBack

###  1.  Planeación de un proyecto de software.

El proyecto consiste en una aplicación de gestión de tareas personales donde los usuarios podrán agregar, marcar como completadas, y eliminar tareas. La aplicación contará con una interfaz web y se conectará a un API REST desarrollado en Spring Boot. El backend permitirá la inyección de dependencias para el manejo de datos, pudiendo optar entre una base de datos en MongoDB Cloud o un archivo de texto plano para almacenar las tareas. Creamos un proyecto en GitHub para el back y para el front de manera independiente, a continuación mediante Spring Initializr  se crea un proyecto con Maven, Java 17 y dependencias requeridas para el trabajo. Se mantuvo el esquema de nombramiento  de los artefactos.

![image](https://github.com/user-attachments/assets/0551209e-8528-40b7-9434-2bbc3d29ac7f)


Se realizo toda la planificación que se requiere para poder dar inicio al proyecto planteado mediante Azure DevOps, por donde se asignó a cada integrante un función específica.


![image](https://github.com/user-attachments/assets/38a054d0-ef55-4113-a247-b8cec3fcabe7)


### 2.  Entender arquitectura cliente servidor.

La arquitectura cliente-servidor es un modelo donde el cliente envía solicitudes a un servidor, que las procesa y responde con los datos solicitados. El cliente inicia la comunicación y el servidor maneja las solicitudes, sirviendo a múltiples clientes al mismo tiempo. 
	
![image](https://github.com/user-attachments/assets/8e0892f4-c5be-4824-ba37-ba29e1d6a258)


### 3.Inyección de dependencias - Inversión de control.

 *Inversión de Control (IoC)*: Es un principio en el que el control del flujo del programa es "invertido". En lugar de que un objeto gestione sus propias dependencias (creando instancias de objetos de los que depende), se delega esta responsabilidad a un contenedor externo. 

*Inyección de Dependencias (DI)*: Es una forma específica de aplicar IoC. En DI, las dependencias  se proporcionan desde fuera,  generalmente por un contenedor. En lugar de que una clase cree sus propias dependencias, estas se "inyectan" a través de diferentes métodos. Esto permite cambiar las dependencias sin modificar el código de la clase. 

a) TaskService (Clase de Servicio): Esta clase maneja la lógica de negocio relacionada con las tareas.

 Inyección de dependencias es utilizada en la anotación `@Autowired` para inyectar la dependencia TaskRepository en el constructor de TaskService,  donde Spring gestiona la creación y vinculación del repositorio, aquí se presenta los métodos principales que se usaron:
    
    
-   `getTasks()`: Retorna una lista de todas las tareas almacenadas.
-   `saveTask(Task task)`: Guarda una tarea en la base de datos.
-   `markTaskAsCompleted(String id)`: Marca una tarea como completada y la guarda en la base de datos.
-   `deleteTask(String id)`: Elimina una tarea de la base de datos si existe
- `getTask(String id)`: Obtiene una tarea por su ID usando el repositorio.
    
   ```java
		package edu.eci.cvds.task_back;  
		import org.springframework.beans.factory.annotation.Autowired;  
		import org.springframework.stereotype.Service;  
		import java.util.List;  
  
		@Service  
		public class TaskService {  
		    private TaskRepository taskRepository;  
  
	    @Autowired  
		  public TaskService(TaskRepository taskRepository) {  
		        this.taskRepository = taskRepository;  
		    }  
		   public Task getTask(String id){  
		        return taskRepository.findById(id).orElse(null);  
		    }  
		   public List<Task> getTasks(){  
		        return taskRepository.findAll();  
		    }  
		    public void saveTask(Task task){  
		        taskRepository.save(task);  
		    }  
		   public void markTaskAsCompleted(String id){  
	       Task taskRepo = getTask(id);  
	        taskRepo.setIsCompleted(true);  
	        if (taskRepo != null){  
	            taskRepository.save(taskRepo);  
	        }  
	    }  
		    public void deleteTask(String id){  
	        Task taskRepo = getTask(id);  
	        if (taskRepo != null){  
	            taskRepository.delete(taskRepo);  
	        }  
	    }  
	} 
```
