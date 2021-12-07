using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._1._9
{
    public class Mobile
    {
        private string Name;
        private List<Phone> Cameras = new List<Phone>();

        public Mobile()
        {
        }

        public Mobile(string name)
        {
            Name = name;
        }

        public Mobile(string name, List<Phone> cameras)
        {
            Name = name;
            Cameras = cameras;
        }

        public void SetName(string name)
        {
            Name = name;
        }

        public string GetName()
        {
            return Name;
        }

        public void SetPositions(List<Phone> cameras)
        {
            Cameras = cameras;
        }

        public List<Phone> GetPositions()
        {
            return Cameras;
        }

        public void AddPosition(Phone phone)
        {
            Cameras.Add(phone);
        }

        public void RemovePosition(Phone phone)
        {
            Cameras.Remove(phone);
        }

        public class Phone
        {
            private string Name;
            private string CPU;
            private int Memory;
            private List<Camera> Cameras = new List<Camera>();

            public Phone()
            {
            }

            public Phone(string name)
            {
                Name = name;
            }

            public Phone(string name, string cpu)
            {
                Name = name;
                CPU = cpu;
            }

            public Phone(string name, string cpu, int memory)
            {
                Name = name;
                CPU = cpu;
                Memory = memory;
            }

            public Phone(string name, string cpu, int memory, List<Camera> camera)
            {
                Name = name;
                CPU = cpu;
                Memory = memory;

            }

            public Phone(string name, List<Camera> cameras)
            {
                Name = name;
                Cameras = cameras;
            }

            public void SetName(string name)
            {
                Name = name;
            }

            public string GetName()
            {
                return Name;
            }

            public void SetCPU(string cpu)
            {
                CPU = cpu;
            }

            public string GetCPU()
            {
                return CPU;
            }

            public void SetMemory(int memory)
            {
                Memory = memory;
            }

            public int GetMemory()
            {
                return Memory;
            }

            public void SetCamera(List<Camera> cameras)
            {
                Cameras = cameras;
            }

            public List<Camera> GetCamera()
            {
                return Cameras;
            }

            public void AddCamera(Camera camera)
            {
                Cameras.Add(camera);
            }

            public void RemoveCamera(Camera camera)
            {
                Cameras.Remove(camera);
            }

            public class Camera
            {
                private int Megapixels;
                private string Name;

                public Camera(int megapixels, string name)
                {
                    Megapixels = megapixels;
                    Name = name;
                }

                public void SetMegapixels(int megapixels)
                {
                    Megapixels = megapixels;
                }

                public int GetMegapixels()
                {
                    return Megapixels;
                }

                public void SetName(string name)
                {
                    Name = name;
                }

                public string GetName()
                {
                    return Name;
                }
            }
        }
    }
}