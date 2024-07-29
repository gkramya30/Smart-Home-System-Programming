
Smart Home System Simulation
Overview
This project simulates a Smart Home System where users can control various smart devices like lights, thermostats, and door locks through a central hub. Users can set schedules, automate tasks, and monitor the status of each device.

Functional Requirements
Initialization: The system should be initialized with different devices, each identified by a unique ID and type (e.g., light, thermostat, door lock).
Device Control: Users should be able to:
Turn devices on and off.
Schedule devices to turn on or off at specific times.
Automate tasks based on triggers 
Dynamic Device Management: The system should allow for adding or removing devices dynamically.
Design Patterns
Behavioral Pattern: The Observer Pattern is used to update all devices when a change occurs in the system.
Creational Pattern: The Factory Method is employed for creating instances of different smart devices.
Structural Pattern: The Proxy Pattern is utilized to control access to the devices.
Key Concepts
Encapsulation: Ensuring that each class hides its internal state and only exposes necessary functionalities.
Modularity: Designing the system in a way that each component is independent and can be modified without affecting others.
Inheritance and Polymorphism: Leveraging these OOP principles to create a flexible and scalable system architecture.
How to Run
	Clone the repository.
	Use the provided interface to control devices, set schedules, and automate tasks.
