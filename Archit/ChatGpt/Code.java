public class Code {
    
    public class MissingArgumentException extends RuntimeException {
        public MissingArgumentException(String message) {
            super(message);
        }
    }

    @PostMapping("/my-endpoint")
    public ResponseEntity<?> myControllerMethod(@RequestBody MyRequestDTO request) {
        // Check if any required fields are missing
        if (request.getField1() == null || request.getField2() == null) {
            throw new MissingArgumentException("Required field(s) missing in request body");
        }
        // ...
        // Rest of your controller logic
        // ...
    }


    @Component
    public class GlobalExceptionHandler implements HandlerExceptionResolver {
        @Override
        public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            if (ex instanceof MissingArgumentException) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                // You can customize the error message here
                return new ModelAndView("error", "message", ex.getMessage());
            }
            // Handle other exceptions here
            return null;
        }
    }

    
}



