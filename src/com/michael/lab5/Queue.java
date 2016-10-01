package com.michael.lab5;

public class Queue
{
    private QueueElement[] elements = new QueueElement[11];

    public void addTask(Task task)
    {
        QueueElement startElement = elements[task.getPriority()];
        QueueElement element = new QueueElement(task, startElement.getNextElement(), startElement.isEnd());

        startElement.setEnd(false);
        startElement.setNextElement(element);
    }

    public void deleteTask(int id)
    {
        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                for (QueueElement element = elements[i]; element.getNextElement() != null; element = element.getNextElement())
                {
                    if (element.getNextElement().getTask().getId() == id)
                    {
                        QueueElement current = element.getNextElement();

                        element.setNextElement(current.getNextElement());
                        element.setEnd(current.isEnd());

                        return;
                    }
                }
            }
        }
    }

    public Task getTask(int id)
    {
        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                for (QueueElement element = elements[i]; element.getNextElement() != null; element = element.getNextElement())
                {
                    if (element.getNextElement().getTask().getId() == id)
                    {
                        return element.getNextElement().getTask();
                    }
                }
            }
        }

        return null;
    }

    public void clear()
    {
        for (QueueElement element : elements)
        {
            element.setNextElement(null);
            element.setEnd(true);
        }
    }

    public Task[] getArrayTasks()
    {
        int count = 0;

        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                for (QueueElement element = elements[i].getNextElement(); element != null; element = element.getNextElement())
                {
                    count++;
                }
            }
        }

        Task[] tasks = new Task[count];
        int k = 0;

        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                for (QueueElement element = elements[i].getNextElement(); element != null; element = element.getNextElement())
                {
                    tasks[k] = element.getTask();
                    k++;
                }
            }
        }

        return tasks;
    }

    public int getSumOflaboriousnessAllTasks()
    {
        int sum = 0;

        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                for (QueueElement element = elements[i].getNextElement(); element != null; element = element.getNextElement())
                {
                    sum += element.getTask().getLaboriousness();
                }
            }
        }

        return sum;
    }

    public void changePriorityTask(int id, int newPriority)
    {
        for (int i = 0; i < 11; i++) {
            if (!elements[i].isEnd()) {
                for (QueueElement element = elements[i]; element.getNextElement() != null; element = element.getNextElement()) {
                    if (element.getNextElement().getTask().getId() == id) {
                        QueueElement current = element.getNextElement();

                        element.setNextElement(current.getNextElement());
                        element.setEnd(current.isEnd());

                        Task task = current.getTask();
                        task.setPriority(newPriority);
                        addTask(task);

                        return;
                    }
                }
            }
        }
    }

    public Task dequeueTask(int id)
    {
        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                for (QueueElement element = elements[i]; element.getNextElement() != null; element = element.getNextElement())
                {
                    if (element.getNextElement().getTask().getId() == id)
                    {
                        QueueElement current = element.getNextElement();

                        element.setNextElement(current.getNextElement());
                        element.setEnd(current.isEnd());

                        return current.getTask();
                    }
                }
            }
        }

        return null;
    }

    public Task getHighestPriorityTask()
    {
        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
                return elements[i].getNextElement().getTask();
        }

        return null;
    }

    public Task dequeueHighestPriorityTask()
    {
        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                QueueElement current = elements[i].getNextElement();

                elements[i].setNextElement(current.getNextElement());
                elements[i].setEnd(current.isEnd());

                return current.getTask();
            }
        }

        return null;
    }

    public Task dequeueHighestPriorityTask(int laboriousness)
    {
        for (int i = 0; i < 11; i++)
        {
            if (!elements[i].isEnd())
            {
                for (QueueElement element = elements[i]; element.getNextElement() != null; element = element.getNextElement())
                {
                    if (element.getNextElement().getTask().getLaboriousness() <= laboriousness)
                    {
                        QueueElement current = element.getNextElement();

                        element.setNextElement(current.getNextElement());
                        element.setEnd(current.isEnd());

                        return current.getTask();
                    }
                }
            }
        }

        return null;
    }

    public Queue()
    {
        for (int i = 0; i < 11; i++)
            elements[i] = new QueueElement();
    }

    private class QueueElement
    {
        private Task task;
        private QueueElement nextElement;
        private boolean isEnd;

        public QueueElement(Task task, QueueElement nextElement, boolean isEnd) {
            this.task = task;
            this.nextElement = nextElement;
            this.isEnd = isEnd;
        }

        public QueueElement() {
            this.task = null;
            this.nextElement = null;
            this.isEnd = true;
        }

        public Task getTask() {
            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public QueueElement getNextElement() {
            return nextElement;
        }

        public void setNextElement(QueueElement nextElement) {
            this.nextElement = nextElement;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
