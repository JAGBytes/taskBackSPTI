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


![image](https://github.com/user-attachments/assets/8443650e-d8ab-4d10-9910-71383ac668fc)



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
   

b) TaskRepository (Interfaz del Repositorio): Es una interfaz que extiende `MongoRepository`, lo que significa que proporciona métodos estándar para interactuar con una base de datos MongoDB. Esta define métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre la colección de tareas en MongoDB.
Por otro lado, se tiene TaskTextRepository para archivos de texto plano para almacenar las tareas.


```java 
	package edu.eci.cvds.task_back;  
	import org.springframework.data.mongodb.repository.MongoRepository;  
	import org.springframework.data.mongodb.repository.Query;  
	import org.springframework.stereotype.Repository;  
	import java.util.List;  
	  
	@Repository  
	public interface TaskRepository extends MongoRepository<Task, String>, TaskTextRepository {  
		}	
```

c) TaskController (Controlador REST):  Expone la API REST para que los clientes  puedan interactuar con el servicio de tareas.
    
Anotaciones:

   -   `@RestController`: Define que esta clase es un controlador REST y puede manejar solicitudes HTTP.
     
   -  `@RequestMapping("/taskManager")`: Define que todas las rutas expuestas por este controlador estarán bajo el prefijo `/taskManager`.
     
   -   `@CrossOrigin(origins = "*")`: Permite peticiones desde cualquier origen (CORS), lo que permite el acceso desde cualquier dominio.
     
    
 Rutas principales:
    
   -   `POST /saveTask`: Permite guardar una tarea mediante una solicitud HTTP POST. Los datos de la tarea se reciben en el cuerpo de la solicitud (`@RequestBody`).

   -  `PATCH /markTaskAsCompleted`: Permite marcar una tarea como completada usando su ID mediante una solicitud HTTP PATCH con el parámetro `id`.

   -  `DELETE /delete`: Elimina una tarea por su ID con una solicitud HTTP DELETE.

   -  `GET /getTasks`: Retorna todas las tareas mediante una solicitud HTTP GET.
    
    
   ```java
		package edu.eci.cvds.task_back;  
		import org.springframework.beans.factory.annotation.Autowired;  
		import org.springframework.web.bind.annotation.*;  
		import org.springframework.web.bind.annotation.CrossOrigin;  
		import java.util.List;  
  
		@RestController  
		@RequestMapping("/taskManager")  
		public class taskController {  
  
	   	 @Autowired  
		 private TaskService taskService;  
	   	 @CrossOrigin(origins = "*")  
	    	@PostMapping("saveTask")  
	   	 public void saveTask(@RequestBody Task task){  
	        	taskService.saveTask(task);  
	    	}  
	   	 @CrossOrigin(origins = "*")  
	   	 @PatchMapping("/markTaskAsCompleted")  
	   	 public void markTaskAsCompleted(@RequestParam String id){  
	        	taskService.markTaskAsCompleted(id);  
	    	}  
	   	 @CrossOrigin(origins = "*")  
	   	 @DeleteMapping("/delete")  
	    	public void deleteTask(@RequestParam String id){  
	  		taskService.deleteTask(id);  
	   	 }  
	    	@CrossOrigin(origins = "*")  
	    	@GetMapping("getTasks")  
	    	public List<Task> getTasks(){  
	        	return taskService.getTasks();  
	   	 }  
	   	 }
```
			
 *Flujo de ejecución*:

1.  El usuario envía una solicitud HTTP al controlador `TaskController`.
2.  El controlador llama a `TaskService`, que gestiona la lógica de negocio.
3.  El servicio usa `TaskRepository` para interactuar con la base de datos MongoDB y realizar operaciones sobre las tareas.
4.  El resultado se devuelve al usuario.

### 4. Manejo de bases de datos no relacionales.

Ahora bien, se descarga e instala MongoDB una base de datos no relacional.

Primero, ejecutamos el instalador descargado, luego se selecciona la opción de instalación "Complete".

Durante la instalación, se activa la opción de instalar MongoDB como un servicio.

![image](https://github.com/user-attachments/assets/76592873-b4ea-48a2-901e-5da75cfd6648)
![image](https://github.com/user-attachments/assets/5960490e-6d75-4e08-98b9-f05ba2a62ab6)

Siguiente a la instalación, configuramos el MongoDB en nuestro proyecto, donde agregamos la dependencia en el `pom.xml`.

![image](https://github.com/user-attachments/assets/347fd7e8-5742-47ce-b020-e19aa5642c33)

Luego, en el paquete de `resources` y en el archivo `aplication.properties` agregamos la configuración de la base de datos.

![image](https://github.com/user-attachments/assets/7a0dfd8d-21b5-4531-baed-6b89a6315ff5)

### 5. Garantizar calidad del código y detección de deuda técnica (pruebas unitarias)

	

### Referencias

-https://start.spring.io

-https://dev.azure.com

-https://www.mongodb.com/try/download/community















