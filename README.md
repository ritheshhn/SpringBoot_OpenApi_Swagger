SpringBoot OpenApi Swagger

https://github.com/ritheshhn/SpringBoot_OpenApi_Swagger.git


1) Each and every Request handling method in each controller should be annotated with @Operation() & @ApiResponse()
        Ex:
           @RestController
           Public Class UserController{
   
                   @Operation(summary = "Adding a new user")
                   @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "User created"),
                        @ApiResponse(responseCode = "500", description = "User already registered")
                  })
                  @PostMapping
                  Public UserDto createUser(){

                  }
           }

3) Each and every Entity class and its properties should be annotated with @Schema
       Ex:
           @Schema(description = "User Entity")
           public class UserEntity {

                 @Id
                 @GeneratedValue
                 @Schema(description = "Unique identifier for the user", example = "1")
                 private long id;
      
                 @Column(nullable=false, length=50)
                 @Schema(description = "First name of the user", example = "Rithesh")
                 private String firstName;
           }
