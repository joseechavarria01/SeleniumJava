Feature: Login con usuario y contraseña correctos

    Cuando el usuario y la contraseña sean correctos, deberá iniciar sesión correctamente

    Scenario Outline: Login con usuario y contraseña válidos
        Given el sitio web está accesible en la URL '<url>'
        Then verificar que la página de inicio (home) se visualice correctamente con los elementos esperados
        When hacer clic en el botón 'Signup Login'
        Then verificar que el texto 'Login to your account' sea visible
        When ingresar el correo electrónico '<email>' y la contraseña '<password>'
        And hacer clic en el botón 'login'
        Then verificar que el nombre de usuario se muestre correctamente en la página principal

        Examples:
            | url                    | email                             | password             |
            | https://automationexercise.com    | xavomawusse-1109@yopmail.com      | QngT0heiO99MGh       |
            | https://automationexercise.com    | xavomawusse-1109@yopmail.com      | QngT0heiO99MGh       |
