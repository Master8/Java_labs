package com.michael.lab5;

public class Solution
{
    public static void main(String[] args)
    {
        Queue queue = new Queue();
        queue.addTask(new Task(1, 3, 18, "Task one"));
        queue.addTask(new Task(2, 2, 8, "Task two"));
        queue.addTask(new Task(3, 3, 10, "Task three"));
        queue.addTask(new Task(4, 0, 20, "Task four"));
        queue.addTask(new Task(5, 0, 14, "Task five"));
        queue.addTask(new Task(6, 1, 3, "Task six"));
        queue.addTask(new Task(7, 9, 9, "Task seven"));
        queue.addTask(new Task(8, 8, 31, "Task eight"));
        queue.addTask(new Task(9, 8, 5, "Task nine"));
        queue.addTask(new Task(10, 3, 4, "Task ten"));

        System.out.println("Заполненный:");

        printArrayTasks(queue.getArrayTasks());

        System.out.println("\nдобавить задачу с приоритетом в очередь");

        queue.addTask(new Task(11, 0, 7, "Task eleven"));

        printArrayTasks(queue.getArrayTasks());

        System.out.println("\nполучить задачу с наивысшим приоритетом из очереди (без ее удаления из очереди");

        Task task = queue.getHighestPriorityTask();

        System.out.println("pr: " + task.getPriority() + " lab: " + task.getLaboriousness() + " des: " +
                task.getDescription());

        System.out.println("\nизвлечь задачу с наивысшим приоритетом из очереди");

        task = queue.dequeueHighestPriorityTask();

        System.out.println("pr: " + task.getPriority() + " lab: " + task.getLaboriousness() + " des: " +
                task.getDescription());

        System.out.println("\nОчередь после извлечения");

        printArrayTasks(queue.getArrayTasks());

        System.out.println("\nизвлечь задачу с наивысшим приоритетом, трудоемкость которой не превышает заданное значение");

        task = queue.dequeueHighestPriorityTask(10);

        System.out.println("pr: " + task.getPriority() + " lab: " + task.getLaboriousness() + " des: " +
                task.getDescription());

        System.out.println("\nОчередь после извлечения");

        printArrayTasks(queue.getArrayTasks());

        System.out.println("\nудалить задачу по ее уникальному номеру из очереди");

        queue.deleteTask(4);

        System.out.println("\nОчередь после удаления");

        printArrayTasks(queue.getArrayTasks());

        System.out.println("\nполучить задачу по ее уникальному номеру из очереди ");

        task = queue.getTask(8);

        System.out.println("pr: " + task.getPriority() + " lab: " + task.getLaboriousness() + " des: " +
                task.getDescription());

        System.out.println("\nизменить приоритет задачи по ее уникальному номеру");

        queue.changePriorityTask(1, 0);

        printArrayTasks(queue.getArrayTasks());

        System.out.println("\nотчистить очередь");

        queue.clear();

        printArrayTasks(queue.getArrayTasks());
    }

    public static void printArrayTasks(Task[] tasks)
    {
        for (Task task : tasks)
            System.out.println("pr: " + task.getPriority() + " lab: " + task.getLaboriousness() + " des: " +
                    task.getDescription());
    }
}
