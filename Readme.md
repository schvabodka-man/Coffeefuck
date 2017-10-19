<p align="center"><a href="url"><img src="https://raw.githubusercontent.com/schvabodka-man/Coffeefuck/master/src/main/resources/static/pics/logo.png" width="200" height="300"></a></p>

<div style="display: inline-block;">
<img src="https://github.com/schvabodka-man/Custom-Badges/blob/master/Languages/Scala/png/Scala%20xxxhdpi.png" width="300" height="50">
<img src="https://raw.githubusercontent.com/schvabodka-man/Custom-Badges/master/Frameworks/png/Spring%20xxxhdpi.png" width="300" height="50">
<img src="http://forthebadge.com/images/badges/uses-js.svg" width="150" height="50">
</div>

Cloud brainfuck interpreter with REST API and web app done via Scala, Vanilla JS and Spring Boot

# Why?
I don't see any good web brainfuck interpreters(especially with debugger)

# What's used?
* Spring MVC for backend
* Vanilla JS and Jquery for frontend(very shitty code in fact, but works)

# Stuff
* Interpreter
* Debugger (can go further and backwards - how many brainfuck debuggers can go backwards?)
* REST api for interpreter and websockets for debugger(see project wiki)

# Screenshots
<img src="https://raw.githubusercontent.com/schvabodka-man/Coffeefuck/master/screenshots/Debugger.png" width="800" height="450">
<img src="https://raw.githubusercontent.com/schvabodka-man/Coffeefuck/master/screenshots/Interpreter.png" width="800" height="450">

# History
One summer day i decided to do some coding and have made a brainfuck interpreter on Scala. Later on i decided to make full blown web app from that

# Problems/Possible improvements
* Frontend is still pretty raw and needs to be more polished. I'm not very savvy in JS, so it would be cool if some guy will help with it
* One little bug in backend
* Performance optimization(no tail recursion?)
* Maybe Android client
