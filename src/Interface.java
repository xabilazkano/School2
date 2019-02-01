import com.zubiri.*;
import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {
		School school = new School();
		Student student = new Student();
		Teacher teacher = new Teacher();
		Administrative admin = new Administrative();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Welcome to our school database, select one of these three");
			System.out.println("1.- Students");
			System.out.println("2.- Teachers");
			System.out.println("3.- Administratives");
			System.out.println("0.- Quit");
			if (sc.hasNextInt()) {
				switch (sc.nextInt()) {
				default:
					System.out.println("Please, enter a valid option");
					break;

				case 1:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add student");
					System.out.println("2.- Delete student");
					System.out.println("3.- Get the age of a student");
					System.out.println("4.- Check absenses of a student");
					System.out.println("5.- Get teachers");
					System.out.println("6.- Add a subject");
					System.out.println("7.- Delete a subject");
					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						default:
							System.out.println("Please, enter a valid option");
							break;

						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							String date = sc.next();
							if (!student.isValidDate(date)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!student.isValidTelephone(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!student.isValidDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}
							System.out.println("Absenses");
							int absenses = sc.nextInt();
							System.out.println("Mark average");
							double average = sc.nextDouble();
							System.out.println("Classroom");
							String classroom = sc.next();

							Student newstudent = new Student(name, date, telephone, dni, absenses, average, classroom);

							if (school.addStudent(newstudent)) {
								System.out.println("Succesfully added");
								newstudent.setStudentID(school.findStudentID(name));
							} else {
								System.out.println("An error happened");
							}

							break;

						case 2:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();

							if (school.deleteStudent(name)) {
								System.out.println("Student removed");
							} else {
								System.out.println("Student not found");
							}
							break;

						case 3:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findStudentID(name) != -1)
								System.out.println(school.getStudent(name).calculateAge());
							else
								System.out.println("Student not found");
							break;

						case 4:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findStudentID(name) != -1)
								System.out.println(school.getStudent(name).checkAbsenses());
							else
								System.out.println("Student not found");
							break;
							
						case 5:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findStudentID(name) != -1)
								school.getTeachersByStudent(name);
							else
								System.out.println("Student not found");
							break;
						
						case 6:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							String subject = sc.next();

							if (school.findStudentID(name) != -1)
								if (school.getStudent(name).addSubject(subject))
									System.out.println("Subject added");
								else
									System.out.println("Subject already added");
							else
								System.out.println("Student not found");
							break;

						case 7:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							subject = sc.next();

							if (school.findStudentID(name) != -1)
								if (school.getStudent(name).deleteSubject(subject))
									System.out.println("Subject deleted");
								else
									System.out.println("Subject not found");
							else
								System.out.println("Student not found");
							break;
						}

					} else {
						System.out.println("Please, enter a valid option");
					}
					break;

				case 2:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add a teacher");
					System.out.println("2.- Delete a teacher");
					System.out.println("3.- Get the age of a teacher");
					System.out.println("4.- Check absenses");
					System.out.println("5.- Check if he/she is tutor");
					System.out.println("6.- Add a subject");
					System.out.println("7.- Delete a subject");
					System.out.println("8.- Get students by tutor");
					System.out.println("9.- Get students by teacher");

					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						default:
							System.out.println("Please, enter a valid option");
							break;

						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							String date = sc.next();
							if (!teacher.isValidDate(date)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!teacher.isValidTelephone(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!teacher.isValidDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}
							System.out.println("Absenses");
							int absenses = sc.nextInt();
							System.out.println("Salary");
							double salary = sc.nextDouble();
							System.out.println("Joined date");
							String joinedDate = sc.next();
							System.out.println("Tutor(write 'no' if not)");
							String tutor = sc.next();

							Teacher newTeacher = new Teacher(name, date, telephone, dni, absenses, salary, joinedDate,
									tutor);

							if (school.addTeacher(newTeacher)) {
								System.out.println("Succesfully added");
								newTeacher.setTeacherID(school.findTeacherID(name));
							} else {
								System.out.println("An error happened");
							}

							break;

						case 2:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();

							if (school.deleteTeacher(name)) {
								System.out.println("Teacher removed");
							} else {
								System.out.println("Teacher not found");
							}
							break;

						case 3:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacherID(name) != -1)
								System.out.println(school.getTeacher(name).calculateAge());
							else
								System.out.println("Teacher not found");

							break;

						case 4:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacherID(name) != -1)
								System.out.println(school.getTeacher(name).checkAbsenses());
							else
								System.out.println("Teacher not found");
							break;

						case 5:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacherID(name) != -1)
								System.out.println(school.getTeacher(name).isTutor());
							else
								System.out.println("Teacher not found");

							break;

						case 6:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							String subject = sc.next();

							if (school.findTeacherID(name) != -1)
								if (school.getTeacher(name).addSubject(subject))
									System.out.println("Subject added");
								else
									System.out.println("Subject already added");
							else
								System.out.println("Teacher not found");
							break;

						case 7:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							subject = sc.next();

							if (school.findTeacherID(name) != -1)
								if (school.getTeacher(name).deleteSubject(subject))
									System.out.println("Subject deleted");
								else
									System.out.println("Subject not found");
							else
								System.out.println("Teacher not found");
							break;
							
						case 8:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							school.getStudentsByTutor(name);
							break;
							
						case 9:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacherID(name) != -1)
								school.getStudentsByTeacher(name);
							else
								System.out.println("Teacher not found");
							break;

						}

					}
					break;

				case 3:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add an administrative");
					System.out.println("2.- Delete an administrative");
					System.out.println("3.- Get the age of an administrative");
					System.out.println("4.- Check absenses");
					System.out.println("5.- Add a language");

					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							String date = sc.next();
							if (!admin.isValidDate(date)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!admin.isValidTelephone(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!admin.isValidDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}
							System.out.println("Absenses");
							int absenses = sc.nextInt();
							System.out.println("Salary");
							double salary = sc.nextDouble();
							System.out.println("Joined date");
							String joinedDate = sc.next();

							Administrative newAdmin = new Administrative(name, date, telephone, dni, absenses, salary,
									joinedDate);

							if (school.addAdministrative(newAdmin)) {
								System.out.println("Succesfully added");
								newAdmin.setAdministrativeID(school.findTeacherID(name));
							} else {
								System.out.println("An error happened");
							}
							break;

						case 2:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();

							if (school.deleteAdministrative(name)) {
								System.out.println("Teacher administrative");
							} else {
								System.out.println("administrative not found");
							}
							break;

						case 3:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findAdministrativeID(name) != -1)
								System.out.println(school.getAdministrative(name).calculateAge());
							else
								System.out.println("Administrative not found");
							break;

						case 4:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findAdministrativeID(name) != -1)
								System.out.println(school.getAdministrative(name).checkAbsenses());
							else
								System.out.println("Administrative not found");
							break;

						case 5:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the language");
							String language = sc.next();
							if (school.findAdministrativeID(name) != -1)
								if (school.getAdministrative(name).addLanguage(language))
									System.out.println("Language added");
								else
									System.out.println("Language already added");
							else
								System.out.println("Administrative not found");
							break;
						}
					}

					break;
				
				case 0:
					flag=false;
					System.out.println("Bye!");
					break;

				}
			} else {
				System.out.println("Please, enter a valid option");
			}
		}
	}

}